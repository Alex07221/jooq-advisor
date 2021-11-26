package cn.yxtreme.jooq.config;

import cn.hutool.core.util.ArrayUtil;
import cn.yxtreme.jooq.listener.*;
import cn.yxtreme.jooq.model.BaseFieldConfig;
import cn.yxtreme.jooq.model.JooqPlusAble;
import lombok.SneakyThrows;
import lombok.val;
import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.jooq.impl.DefaultRecordListenerProvider;
import org.jooq.impl.DefaultVisitListenerProvider;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jooq.JooqProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.stream.Collectors;

/**
 * @author: Alex
 * @since: 2021/7/27
 */
public class JooqAdvisorConfiguration {

    @Bean
    @ConditionalOnMissingBean({Configuration.class})
    @Primary
    @SneakyThrows
    public DefaultConfiguration jooqConfiguration(JooqProperties properties
            , ConnectionProvider connectionProvider
            , DataSource dataSource
            , ObjectProvider<TransactionProvider> transactionProvider
            , ObjectProvider<RecordMapperProvider> recordMapperProvider
            , ObjectProvider<RecordUnmapperProvider> recordUnmapperProvider
            , ObjectProvider<Settings> settings
            , ObjectProvider<RecordListenerProvider> recordListenerProviders
            , ObjectProvider<ExecuteListenerProvider> executeListenerProviders
            , ObjectProvider<VisitListenerProvider> visitListenerProviders
            , ObjectProvider<TransactionListenerProvider> transactionListenerProviders
            , ObjectProvider<ExecutorProvider> executorProvider) {

        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(properties.determineSqlDialect(dataSource));
        configuration.set(connectionProvider);
        transactionProvider.ifAvailable(configuration::set);
        recordMapperProvider.ifAvailable(configuration::set);
        recordUnmapperProvider.ifAvailable(configuration::set);
        settings.ifAvailable(configuration::set);
        executorProvider.ifAvailable(configuration::set);


        var visits = visitListenerProviders.orderedStream().collect(Collectors.toSet());
        var executes = executeListenerProviders.orderedStream().collect(Collectors.toSet());
        var records = recordListenerProviders.orderedStream().collect(Collectors.toSet());

        var fieldConfig = ((Class<? extends BaseFieldConfig>) JooqAdvisorProperties.properties.get("fieldClass")).getConstructor().newInstance();
        var tablesClass = (Class<?>) JooqAdvisorProperties.properties.get("tablesClass");

        var logicDelete = DefaultVisitListenerProvider.providers(new YuJiLogicVisitListener(tablesClass, fieldConfig.getDeleteField()))[0];
        var pageable = DefaultVisitListenerProvider.providers(new YuJiPageVisitListener(tablesClass))[0];
        var execute = DefaultExecuteListenerProvider.providers(new YuJiExecuteListener())[0];
        var insertRecord = DefaultRecordListenerProvider.providers(new YuJiInsertRecordListener(fieldConfig.getInsertField()))[0];
        var updateRecord = DefaultRecordListenerProvider.providers(new YuJiUpdateRecordListener(fieldConfig.getUpdateField()))[0];

        for (val jooqPlusAble : (JooqPlusAble[]) JooqAdvisorProperties.properties.get("value")) {
            switch (jooqPlusAble) {
                case ALL:
                    visits.add(pageable);
                    visits.add(logicDelete);
                    executes.add(execute);
                    records.add(insertRecord);
                    records.add(updateRecord);
                    break;
                case LOGIC_DELETE:
                    visits.add(logicDelete);
                    break;
                case PAGEABLE:
                    visits.add(pageable);
                    executes.add(execute);
                    break;
                case INSERT_DEFAULT:
                    records.add(insertRecord);
                    break;
                case UPDATE_DEFAULT:
                    records.add(updateRecord);
                    break;
                default:
                    break;
            }
        }
        executes.add(DefaultExecuteListenerProvider.providers(new YujiLoggerListener())[0]);
        configuration.set(ArrayUtil.toArray(visits, VisitListenerProvider.class));
        configuration.set(ArrayUtil.toArray(executes, ExecuteListenerProvider.class));
        configuration.set(ArrayUtil.toArray(records, RecordListenerProvider.class));
        configuration.setTransactionListenerProvider(transactionListenerProviders.orderedStream().toArray(TransactionListenerProvider[]::new));

        if ((Boolean) JooqAdvisorProperties.properties.get("printBanner")) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println();
            System.out.println("    _____   ___      ___      ___            _            __          _                         \n" +
                    "   |_   _|.'   `.  .'   `.  .'   `.         / \\          |  ]        (_)                        \n" +
                    "     | | /  .-.  \\/  .-.  \\/  .-.  \\       / _ \\     .--.| | _   __  __   .--.   .--.   _ .--.  \n" +
                    " _   | | | |   | || |   | || |   | |      / ___ \\  / /'`\\' |[ \\ [  ][  | ( (`\\]/ .'`\\ \\[ `/'`\\] \n" +
                    "| |__' | \\  `-'  /\\  `-'  /\\  `-'  \\_   _/ /   \\ \\_| \\__/  | \\ \\/ /  | |  `'.'.| \\__. | | |     \n" +
                    "`.____.'  `.___.'  `.___.'  `.___.\\__| |____| |____|'.__.;__] \\__/  [___][\\__) )'.__.' [___]    \n");
            System.out.println();
            System.out.println("version: 1.3.8");
            System.out.println("see more detail to https://github.com/Alex07221/jooq-advisor/tree/master");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }

        return configuration;
    }

}
