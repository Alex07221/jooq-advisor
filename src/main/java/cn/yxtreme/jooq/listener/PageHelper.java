package cn.yxtreme.jooq.listener;

import cn.hutool.core.bean.BeanUtil;
import cn.yxtreme.jooq.utils.Classes;
import cn.yxtreme.jooq.utils.SingleStack;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

/**
 * It's advice about auto make pagination
 * <p>
 * TODO use the way of ${@link QueryPart} to  build sql
 *
 * @author: Alex
 * @since: 2021/7/29
 */
public class PageHelper {

    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PageHelper.class);
    /**
     * here are some stack for inquire.
     */
    private final SingleStack<Select> selectSingleStack;
    private final SingleStack<List<QueryPart>> queryPartsSingleStack;
    private final SingleStack<List<QueryPart>> havingConditionSingleStack;
    private final SingleStack<List<Field>> groupField;
    private final SingleStack<List<Table>> tablesSingleStack;
    /**
     * here are some boolean for mark
     */
    private Boolean readingTotal = false;
    private Boolean prepareSelectTotal = false;
    private Boolean selectingOriginal = false;
    /**
     * here is information for doing page
     */
    private PageInfo pageInfo;

    PageHelper() {
        tablesSingleStack = new SingleStack(new ArrayList<Table>());
        queryPartsSingleStack = new SingleStack(new ArrayList<QueryPart>());
        havingConditionSingleStack = new SingleStack(new ArrayList<QueryPart>());
        groupField = new SingleStack<>(new ArrayList<>());
        selectSingleStack = new SingleStack(DSL.selectCount());
    }

    public static synchronized void startPage(Long pageSize, Long currentPage) {
        AdvisorContext.startPage(pageSize, currentPage);
    }

    public static synchronized Page pageInfo() {
        PageInfo pageInfo = AdvisorContext.getPageHelper().getPageInfo();
        AdvisorContext.destroyContext();
        return BeanUtil.copyProperties(pageInfo, Page.class);
    }

    /**
     * here are some function for recording page information
     */
    void initPageInfo(Long pageSize, Long currentPage) {
        pageInfo = new PageInfo(pageSize, currentPage);
    }

    void initPageInfo() {
        pageInfo = new PageInfo();
    }

    void buildPageInfo(Long total) {
        pageInfo.buildPageInfo(total);
    }

    /**
     * here are some function for recording select stack
     */
    void recordTables(Table table) {
        this.tablesSingleStack.data().add(table);
    }

    void recordQueryPart(QueryPart queryPart) {
        if (!queryPartsSingleStack.data().contains(queryPart)) {
            queryPartsSingleStack.data().add(queryPart);
        }
    }

    void recordGroupField(Field field) {
        if (!groupField.data().contains(field)) {
            groupField.data().add(field);
        }
    }

    void recordHavingCondition(QueryPart condition) {
        if (!havingConditionSingleStack.data().contains(condition)) {
            havingConditionSingleStack.data().add(condition);
        }
    }

    /**
     * Create page word and auto execute.
     *
     * @param context
     */
    void doPage(VisitContext context) {
        //If allow select total of number, and it's not reading.
        if (prepareSelectTotal && !readingTotal) {
            log.debug("开始准备分页");
            /*
             * Split query part to where their belong, here is member explanation.
             * joinTable is the key to join table.
             * tables is which table you select.
             * conditions is about which condition in where and which key word in the whole statement.
             * */
            var all = queryPartsSingleStack.data();
            List<Table> tables = new ArrayList<>();
            List<QueryPart> conditions = new ArrayList<>();
            List<QueryPart> joinTable = new ArrayList<>();
            for (QueryPart queryPart : all) {
                if (Classes.compareTypeByName(queryPart, "org.jooq.impl.JoinTable")) {
                    joinTable.add(queryPart);
                } else if (queryPart instanceof Table) {
                    tables.add((Table) queryPart);
                } else if (queryPart instanceof Condition && !isFieldCondition(queryPart)) {
                    conditions.add(queryPart);
                } else if (queryPart instanceof Keyword) {
                    conditions.add(queryPart);
                }
            }
            /* join every part in dsl */
            joinTable(tables, joinTable);
            joinWhere(conditions);
            joinHaving();
            //ready to execute the word
            prepareSelectTotal = false;
            readingTotal = true;
            log.debug("执行分页开始");
            context.dsl().execute(selectSingleStack.data());
        }
    }

    private void joinWhere(List<QueryPart> conditions) {
        var isOr = false;
        var flag1 = true;
        var notMeetWhere = true;
        for (QueryPart condition : conditions) {
            var data = selectSingleStack.data();
            /* skip the KeyWord, but do some processing when 'group' or 'or' come up  */
            if (condition instanceof Keyword) {
                var asIs = (String) Classes.getFieldValue(condition, "asIs");
                switch (asIs) {
                    case "or":
                        isOr = true;
                        break;
                    case "group by":
                        SelectConditionStep data1 = (SelectConditionStep) data;
                        selectSingleStack.refresh(data1.groupBy(groupField.data()));
                        break;
                    case "where":
                        notMeetWhere = false;
                        break;
                    default:
                        break;
                }
                continue;
            }

            // if condition "where" did not appear, skip loop
            if (notMeetWhere) {
                continue;
            }
            // When we first come here, it should be 'where' case, so it only needs once
            if (flag1) {
                selectSingleStack.refresh(((SelectOnConditionStep) data).where(((Condition) condition)));
                flag1 = false;
            } else {
                /* When the KeyWord 'or' needs be processing... emm, well, we already know.
                 * On the other hand, it should always be 'and'
                 */
                if (isOr) {
                    selectSingleStack.refresh(((SelectConditionStep) data).or(((Condition) condition)));
                    isOr = false;
                } else {
                    selectSingleStack.refresh(((SelectConditionStep) data).and(((Condition) condition)));
                }
            }
        }
    }

    private void joinTable(List<Table> tables, List<QueryPart> joinTable) {
        var flag = true;
        int i = 0;
        for (Table table : tables) {
            var data = selectSingleStack.data();
            // When we first come here, it should be 'from' case, so it only needs once, the others are 'join' case whatever their type
            if (flag) {
                selectSingleStack.refresh(((SelectSelectStep) data).from(table));
                flag = false;
            } else {
                QueryPart queryPart = joinTable.get(i);
                SelectOnStep<?> join = ((SelectJoinStep<?>) data).join(table, (JoinType) Classes.getFieldValue(queryPart, "type"));
                selectSingleStack.refresh(join.on((Condition) Classes.getFieldValue(queryPart, "condition")));
                i++;
            }
        }
    }

    private void joinHaving() {
        var flag1 = true;
        boolean isOr = false;
        //Pretty same with 'joinWhere', don't need to explain again
        for (QueryPart data : havingConditionSingleStack.data()) {
            var select = selectSingleStack.data();
            if (Classes.compareTypeByName(data, "org.jooq.impl.CombinedCondition")) {
                continue;
            }
            if (data instanceof Keyword) {
                var asIs = (String) Classes.getFieldValue(data, "asIs");
                if ("or".equalsIgnoreCase(asIs)) {
                    isOr = true;
                }
                continue;
            }
            if (flag1) {
                selectSingleStack.refresh(((SelectHavingStep) select).having(((Condition) data)));
                flag1 = false;
            } else {
                if (isOr) {
                    selectSingleStack.refresh(((SelectHavingConditionStep) select).or(((Condition) data)));
                    isOr = false;
                } else {
                    selectSingleStack.refresh(((SelectHavingConditionStep) select).and(((Condition) data)));
                }
            }
        }
    }

    /**
     * some condition is use for join table, it's not what we need
     *
     * @param condition
     * @return
     */
    private boolean isFieldCondition(Object condition) {
        return Classes.compareTypeByName(condition, "org.jooq.impl.FieldCondition");
    }


    /**
     * @author: Alex
     * @since: 2021/8/4
     */
    static final class PageInfo {
        private final boolean doPage;
        private Long currentPage;
        private Long pageSize;
        private Long total;
        private Long pageTotal;
        private Long offset;

        private PageInfo(Long pageSize, Long currentPage) {
            this.doPage = true;
            this.pageSize = pageSize;
            this.currentPage = currentPage < 1 ? 1 : currentPage;
        }

        public PageInfo() {
            this.doPage = false;
        }

        /**
         * set page information
         */
        private void buildPageInfo(Long total) {
            this.total = total;
            this.pageTotal = (total + this.pageSize - 1) / this.pageSize;
            this.currentPage = currentPage > pageTotal ? pageTotal : currentPage;
            var offset = (this.currentPage - 1) * this.pageSize;
            this.offset = offset <= 0 ? 0 : offset;
        }


        @SuppressWarnings("all")
        public boolean isDoPage() {
            return this.doPage;
        }

        @SuppressWarnings("all")
        public Long getCurrentPage() {
            return this.currentPage;
        }

        @SuppressWarnings("all")
        public Long getPageSize() {
            return this.pageSize;
        }

        @SuppressWarnings("all")
        public Long getTotal() {
            return this.total;
        }

        @SuppressWarnings("all")
        public Long getPageTotal() {
            return this.pageTotal;
        }

        @SuppressWarnings("all")
        public Long getOffset() {
            return this.offset;
        }

    }


    /**
     * here are some boolean for mark
     */
    @SuppressWarnings("all")
    public Boolean getReadingTotal() {
        return this.readingTotal;
    }

    /**
     * here are some boolean for mark
     */
    @SuppressWarnings("all")
    public void setReadingTotal(final Boolean readingTotal) {
        this.readingTotal = readingTotal;
    }

    @SuppressWarnings("all")
    public Boolean getPrepareSelectTotal() {
        return this.prepareSelectTotal;
    }

    @SuppressWarnings("all")
    public void setPrepareSelectTotal(final Boolean prepareSelectTotal) {
        this.prepareSelectTotal = prepareSelectTotal;
    }

    @SuppressWarnings("all")
    public Boolean getSelectingOriginal() {
        return this.selectingOriginal;
    }

    @SuppressWarnings("all")
    public void setSelectingOriginal(final Boolean selectingOriginal) {
        this.selectingOriginal = selectingOriginal;
    }

    /**
     * here is information for doing page
     */
    @SuppressWarnings("all")
    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

}
