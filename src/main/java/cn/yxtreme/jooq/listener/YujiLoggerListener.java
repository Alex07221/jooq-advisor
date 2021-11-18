package cn.yxtreme.jooq.listener;

import org.jooq.Configuration;
import org.jooq.ExecuteContext;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultExecuteListener;
import org.jooq.tools.JooqLogger;

import java.util.Objects;

import static java.lang.Boolean.TRUE;

/**
 * It's listener about auto make pagination for jooq before execute
 *
 * @author: Alex
 * @since: 2021/7/29
 */
public class YujiLoggerListener extends DefaultExecuteListener {

    private static final JooqLogger log = JooqLogger.getLogger(YujiLoggerListener.class);

    @Override
    public void renderEnd(ExecuteContext ctx) {
        Configuration configuration = ctx.configuration();
        String newline = TRUE.equals(configuration.settings().isRenderFormatted()) ? "\n" : "";
        if (ctx.query() != null) {
            String inlined = DSL.using(configuration).renderInlined(ctx.query());
            if (!Objects.equals(ctx.sql(), inlined)) {
                log.info("Executing query with bind values", newline + inlined);
            }
        } else if (ctx.routine() != null) {

            String inlined = DSL.using(configuration).renderInlined(ctx.routine());

            if (!Objects.equals(ctx.sql(), inlined)) {
                log.info("Executing query with bind values", newline + inlined);
            }
        }

    }
}
