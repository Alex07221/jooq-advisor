package cn.yxtreme.jooq.listener;

import lombok.extern.slf4j.Slf4j;
import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;

/**
 * It's listener about auto make pagination for jooq before execute
 *
 * @author: Alex
 * @since: 2021/7/29
 */
@Slf4j
public class YuJiExecuteListener extends DefaultExecuteListener {

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

    @Override
    public void prepareStart(ExecuteContext ctx) {
        // TODO: 2021/8/4 将sql注入替换成其他形式
        if (doPage() && pageHelper().getSelectingOriginal()) {
            String sql = ctx.sql();
            sql += String.format(" limit %s offset %s ", pageHelper().getPageInfo().getPageSize(), pageHelper().getPageInfo().getOffset());
            ctx.sql(sql);
        }
        super.prepareStart(ctx);
    }

    @Override
    public void recordEnd(ExecuteContext ctx) {
        if (doPage() && pageHelper().getReadingTotal()) {
            log.debug("读取总数据量");
            pageHelper().buildPageInfo(ctx.record().getValue(0, Long.class));
        }
        super.recordEnd(ctx);
    }

    @Override
    public void end(ExecuteContext ctx) {
        if (doPage()) {
            if (pageHelper().getReadingTotal() && pageHelper().getPrepareSelectTotal()) {
                pageHelper().setSelectingOriginal(true);
                pageHelper().setPrepareSelectTotal(false);
                pageHelper().setReadingTotal(false);
                log.debug("分页查询结束");
            } else if (pageHelper().getSelectingOriginal()) {
                pageHelper().setSelectingOriginal(false);
                log.debug("原始查询结束");
            }
        }
        super.end(ctx);
    }

}
