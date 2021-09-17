package cn.yxtreme.jooq.listener;

import cn.yxtreme.jooq.utils.SingleStack;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.ExecuteContext;
import org.jooq.Table;
import org.jooq.VisitContext;
import org.jooq.impl.DefaultExecuteListener;

import java.util.ArrayList;
import java.util.List;

/**
 * It's listener about auto make pagination for jooq before execute
 *
 * @author: Alex
 * @since: 2021/7/29
 */
@Slf4j
public class YuJiExecuteListener extends DefaultExecuteListener {

    private PageHelper pageHelper(ExecuteContext context) {
        PageHelper data = (PageHelper) context.dsl().data("pageHelper");

        if (data == null) {
            data = AdvisorContext.getPageHelper();
            context.dsl().data("pageHelper", data);
        }

        return data;
    }

    private Boolean doPage(ExecuteContext context) {
        Boolean data = (Boolean) context.dsl().data("doPage");
        if (data == null) {
            var doPage = pageHelper(context).getPageInfo().getDoPage();
            data = doPage == null ? false : doPage;
            context.dsl().data("doPage", data);
        }
        return data;
    }
    private void destroy(ExecuteContext context) {
        context.dsl().data().clear();
    }

    @Override
    public void start(ExecuteContext ctx) {
        pageHelper(ctx);
        doPage(ctx);
        super.start(ctx);
    }

    @Override
    public void prepareStart(ExecuteContext ctx) {
        // TODO : 2021/8/4 将sql注入替换成其他形式
        if (doPage(ctx) && pageHelper(ctx).getSelectingOriginal()) {
            String sql = ctx.sql();
            sql += String.format(" limit %s offset %s ", pageHelper(ctx).getPageInfo().getPageSize(), pageHelper(ctx).getPageInfo().getOffset());
            ctx.sql(sql);
        }
        super.prepareStart(ctx);
    }

    @Override
    public void recordEnd(ExecuteContext ctx) {
        if (doPage(ctx) && pageHelper(ctx).getReadingTotal()) {
            log.debug("读取总数据量");
            pageHelper(ctx).buildPageInfo(ctx.record().getValue(0, Long.class));
        }
        super.recordEnd(ctx);
    }

    @Override
    public void end(ExecuteContext ctx) {
        if (doPage(ctx)) {
            if (pageHelper(ctx).getReadingTotal() && pageHelper(ctx).getPrepareSelectTotal()) {
                pageHelper(ctx).setSelectingOriginal(true);
                pageHelper(ctx).setPrepareSelectTotal(false);
                pageHelper(ctx).setReadingTotal(false);
                log.debug("分页查询结束");
            } else if (pageHelper(ctx).getSelectingOriginal()) {
                pageHelper(ctx).setSelectingOriginal(false);
                destroy(ctx);
                log.debug("原始查询结束");
            }
        }
        super.end(ctx);
    }
//
//    private PageHelper pageHelper;
//    private Boolean doPage;
//
//    @Override
//    public void start(ExecuteContext ctx) {
//        ctx.data("test","test");
//        pageHelper = AdvisorContext.getPageHelper();
//        if (pageHelper != null) {
//            doPage = pageHelper.getPageInfo().getDoPage();
//        } else {
//            doPage = false;
//        }
//        super.start(ctx);
//    }
//
//    @Override
//    public void prepareStart(ExecuteContext ctx) {
//        // TODO: 2021/8/4 将sql注入替换成其他形式
//        if (doPage && pageHelper.getSelectingOriginal()) {
//            String sql = ctx.sql();
//            sql += String.format(" limit %s offset %s ", pageHelper.getPageInfo().getPageSize(), pageHelper.getPageInfo().getOffset());
//            ctx.sql(sql);
//        }
//        super.prepareStart(ctx);
//    }
//
//    @Override
//    public void recordEnd(ExecuteContext ctx) {
//        if (doPage && pageHelper.getReadingTotal()) {
//            log.debug("读取总数据量");
//            pageHelper.buildPageInfo(ctx.record().getValue(0, Long.class));
//        }
//        super.recordEnd(ctx);
//    }
//
//    @Override
//    public void end(ExecuteContext ctx) {
//        if (doPage) {
//            if (pageHelper.getReadingTotal() && pageHelper.getPrepareSelectTotal()) {
//                pageHelper.setSelectingOriginal(true);
//                pageHelper.setPrepareSelectTotal(false);
//                pageHelper.setReadingTotal(false);
//                log.debug("分页查询结束");
//            } else if (pageHelper.getSelectingOriginal()) {
//                pageHelper.setSelectingOriginal(false);
//                pageHelper = null;
//                doPage = null;
//                log.debug("原始查询结束");
//            }
//        }
//        super.end(ctx);
//    }
}
