package cn.yxtreme.jooq.listener;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class YuJiPageVisitListener extends BaseVisitListener {

    private PageHelper pageHelper;
    private Boolean doPage;

    public YuJiPageVisitListener(Class<?> tablesClass) {
        super(tablesClass);
    }

    /**
     * init what we need
     */
    @Override
    void push() {
        log.debug("初始化分页条件");
        pageHelper = PaginationContext.getPageHelper();

        if (pageHelper != null) {
            doPage = pageHelper.getPageInfo().getDoPage();
        } else {
            doPage = false;
        }
    }

    /**
     * destroy what we need
     */
    @Override
    void pop() {
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
                pageHelper.recordTables(table);
                pageHelper.recordQueryPart(queryPart);
            }
        } else if (queryPart instanceof Condition || queryPart instanceof Keyword) {
            pageHelper.recordQueryPart(queryPart);
        }

        if (clauses(context).contains(SELECT_GROUP_BY)) {
            if (queryPart instanceof Field) {
                pageHelper.recordGroupField((Field) queryPart);
            }
        }

        if (clauses(context).contains(SELECT_HAVING)) {
            if (queryPart instanceof Condition || queryPart instanceof Keyword) {
                pageHelper.recordHavingCondition(queryPart);
            }
        }
    }

    @Override
    public void clauseStart(VisitContext context) {
        // Enter a new SELECT clause
        if (context.clause() == SELECT) {
            push();
        }
    }

    @Override
    public void clauseEnd(VisitContext context) {
        // Leave a SELECT clause
        if (context.clause() == SELECT && doPage) {
            if (!pageHelper.getSelectingOriginal()) {
                log.debug("允许进行组装分页信息");
                pageHelper.setPrepareSelectTotal(true);
            }
            pageHelper.doPage(context);
        }
    }

    @Override
    public void visitEnd(VisitContext context) {
        if (clauses(context).contains(SELECT) && doPage && !pageHelper.getReadingTotal()) {
            joinPageCondition(context);
        }
    }
}
