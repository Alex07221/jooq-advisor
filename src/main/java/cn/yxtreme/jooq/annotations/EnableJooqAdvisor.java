package cn.yxtreme.jooq.annotations;

import cn.yxtreme.jooq.config.JooqAdvisorConfiguration;
import cn.yxtreme.jooq.config.JooqAdvisorProperties;
import cn.yxtreme.jooq.model.BaseFieldConfig;
import cn.yxtreme.jooq.model.JooqPlusAble;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: Alex
 * @since: 2021/8/10
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({JooqAdvisorProperties.class, JooqAdvisorConfiguration.class})
public @interface EnableJooqAdvisor {
    JooqPlusAble[] value() default {JooqPlusAble.ALL};

    Class<?> tablesClass();

    Class<? extends BaseFieldConfig> fieldClass() default BaseFieldConfig.class;

    boolean printBanner() default true;
}
