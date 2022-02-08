package cn.yxtreme.jooq.config;

import cn.yxtreme.jooq.annotations.EnableJooqAdvisor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author: Alex
 * @since: 2021/8/10
 */
public class JooqAdvisorProperties implements ImportBeanDefinitionRegistrar {

    static Map<String, Object> properties;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        properties = Map.copyOf(importingClassMetadata.getAnnotationAttributes(EnableJooqAdvisor.class.getName()));
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry, importBeanNameGenerator);
    }
}
