package cn.yxtreme.jooq.listener;

import org.jooq.*;
import static org.jooq.Clause.*;

/**
 * It's listener about auto make pagination for jooq
 * <p>
 * TODO wait for jooq version update to replace the ${@link Clause}
 *
 * @author: Alex
 * @since: 2021/7/28
 */
public class YuJiPageVisitListener extends BaseVisitListener {
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(YuJiPageVisitListener.class);

    public YuJiPageVisitListener(Class<?> tablesClass) {
        super(tablesClass);
    }

    private PageHelper pageHelper() {
        return AdvisorContext.getPageHelper();
    }

    private boolean doPage() {
        PageHelper pageHelper = AdvisorContext.getPageHelper();
        if (pageHelper != null) {
            PageHelper.PageInfo pageInfo = pageHelper.getPageInfo();
            if (pageInfo != null) {
                return pageInfo.isDoPage();
            }
        }
        return false;
    }

    /**
     * join the condition to stack for make pagination
     *
     * @param context
     */
    void joinPageCondition(VisitContext context) {
        var queryPart = context.queryPart();
        if (queryPart instanceof Table) {
            Table table = (Table) queryPart;
            if (!(clauses(context).contains(TABLE_ALIAS) && ORIGINAL_TABLE_NAMES.contains(table.getName()))) {
                pageHelper().recordTables(table);
                pageHelper().recordQueryPart(queryPart);
            }
        } else if (queryPart instanceof Condition || queryPart instanceof Keyword) {
            pageHelper().recordQueryPart(queryPart);
        }
        if (clauses(context).contains(SELECT_GROUP_BY)) {
            if (queryPart instanceof Field) {
                pageHelper().recordGroupField((Field) queryPart);
            }
        }
        if (clauses(context).contains(SELECT_HAVING)) {
            if (queryPart instanceof Condition || queryPart instanceof Keyword) {
                pageHelper().recordHavingCondition(queryPart);
            }
        }
    }

    @Override
    public void clauseEnd(VisitContext context) {
        // Leave a SELECT clause
        if (context.clause() == SELECT && doPage()) {
            if (!pageHelper().getSelectingOriginal()) {
                log.debug("允许进行组装分页信息");
                pageHelper().setPrepareSelectTotal(true);
            }
            pageHelper().doPage(context);
        }
    }

    @Override
    public void visitEnd(VisitContext context) {
        if (clauses(context).contains(SELECT) && doPage() && !pageHelper().getReadingTotal()) {
            joinPageCondition(context);
        }
    }
}
