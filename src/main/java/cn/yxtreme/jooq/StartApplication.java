package cn.yxtreme.jooq;

import cn.yxtreme.jooq.annotations.EnableJooqAdvisor;
import cn.yxtreme.jooq.jooq.Tables;
import cn.yxtreme.jooq.model.JooqPlusAble;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@SpringBootApplication
@EnableJooqAdvisor(tablesClass = Tables.class, value = JooqPlusAble.PAGEABLE)
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
