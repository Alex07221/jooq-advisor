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


    private PageHelper pageHelper(VisitContext context) {
        PageHelper data = (PageHelper) context.dsl().data("pageHelper");

        if (data == null) {
            data = AdvisorContext.getPageHelper();
            context.dsl().data("pageHelper", data);
        }

        return data;
    }

    private Boolean doPage(VisitContext context) {
        Boolean data = (Boolean) context.dsl().data("doPage");
        if (data == null) {
            var doPage = pageHelper(context).getPageInfo().getDoPage();
            data = doPage == null ? false : doPage;
            context.dsl().data("doPage", data);
        }
        return data;
    }

    public YuJiPageVisitListener(Class<?> tablesClass) {
        super(tablesClass);
    }

    /**
     * init what we need
     */
    @Override
    void push(VisitContext context) {
        log.debug("初始化分页条件");
        pageHelper(context);
        doPage(context);
    }

    /**
     * destroy what we need
     */
    @Override
    void pop(VisitContext context) {
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
                pageHelper(context).recordTables(table);
                pageHelper(context).recordQueryPart(queryPart);
            }
        } else if (queryPart instanceof Condition || queryPart instanceof Keyword) {
            pageHelper(context).recordQueryPart(queryPart);
        }

        if (clauses(context).contains(SELECT_GROUP_BY)) {
            if (queryPart instanceof Field) {
                pageHelper(context).recordGroupField((Field) queryPart);
            }
        }

        if (clauses(context).contains(SELECT_HAVING)) {
            if (queryPart instanceof Condition || queryPart instanceof Keyword) {
                pageHelper(context).recordHavingCondition(queryPart);
            }
        }
    }

    @Override
    public void clauseStart(VisitContext context) {
        // Enter a new SELECT clause
        if (context.clause() == SELECT) {
            push(context);
        }
    }

    @Override
    public void clauseEnd(VisitContext context) {
        // Leave a SELECT clause
        if (context.clause() == SELECT && doPage(context)) {
            if (!pageHelper(context).getSelectingOriginal()) {
                log.debug("允许进行组装分页信息");
                pageHelper(context).setPrepareSelectTotal(true);
            }
            pageHelper(context).doPage(context);
        }
    }

    @Override
    public void visitEnd(VisitContext context) {
        if (clauses(context).contains(SELECT) && doPage(context) && !pageHelper(context).getReadingTotal()) {
            joinPageCondition(context);
        }
    }
//
//        private PageHelper pageHelper;
//    private Boolean doPage;
//
//    public YuJiPageVisitListener(Class<?> tablesClass) {
//        super(tablesClass);
//    }
//
//    /**
//     * init what we need
//     */
//    @Override
//    void push(VisitContext context) {
//        System.err.println("上下文传递"+context.data("test"));
//        log.debug("初始化分页条件");
//        pageHelper = AdvisorContext.getPageHelper();
//
//        if (pageHelper != null) {
//            doPage = pageHelper.getPageInfo().getDoPage();
//        } else {
//            doPage = false;
//        }
//    }
//
//    /**
//     * destroy what we need
//     */
//    @Override
//    void pop(VisitContext context) {
//    }
//
//
//    /**
//     * join the condition to stack for make pagination
//     *
//     * @param context
//     */
//    void joinPageCondition(VisitContext context) {
//        var queryPart = context.queryPart();
//        if (queryPart instanceof Table) {
//            Table table = (Table) queryPart;
//            if (!(clauses(context).contains(TABLE_ALIAS) && ORIGINAL_TABLE_NAMES.contains(table.getName()))) {
//                pageHelper.recordTables(table);
//                pageHelper.recordQueryPart(queryPart);
//            }
//        } else if (queryPart instanceof Condition || queryPart instanceof Keyword) {
//            pageHelper.recordQueryPart(queryPart);
//        }
//
//        if (clauses(context).contains(SELECT_GROUP_BY)) {
//            if (queryPart instanceof Field) {
//                pageHelper.recordGroupField((Field) queryPart);
//            }
//        }
//
//        if (clauses(context).contains(SELECT_HAVING)) {
//            if (queryPart instanceof Condition || queryPart instanceof Keyword) {
//                pageHelper.recordHavingCondition(queryPart);
//            }
//        }
//    }
//
//    @Override
//    public void clauseStart(VisitContext context) {
//        // Enter a new SELECT clause
//        if (context.clause() == SELECT) {
//            push(context);
//        }
//    }
//
//    @Override
//    public void clauseEnd(VisitContext context) {
//        // Leave a SELECT clause
//        if (context.clause() == SELECT && doPage) {
//            if (!pageHelper.getSelectingOriginal()) {
//                log.debug("允许进行组装分页信息");
//                pageHelper.setPrepareSelectTotal(true);
//            }
//            pageHelper.doPage(context);
//        }
//    }
//
//    @Override
//    public void visitEnd(VisitContext context) {
//        if (clauses(context).contains(SELECT) && doPage && !pageHelper.getReadingTotal()) {
//            joinPageCondition(context);
//        }
//    }
}
