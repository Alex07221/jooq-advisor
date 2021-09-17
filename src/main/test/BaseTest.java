import cn.yxtreme.jooq.StartApplication;
import cn.yxtreme.jooq.listener.PageHelper;
import cn.yxtreme.jooq.temp.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@SpringBootTest(classes = StartApplication.class)
@RunWith(SpringRunner.class)
public class BaseTest {

    @Autowired
    private T1Re t1Re;
    @Autowired
    private T2Re t2Re;
    @Autowired
    private T3Re t3Re;
    @Autowired
    private T4Re t4Re;
    @Autowired
    private T5Re t5Re;


    @Test
    public void name() throws InterruptedException {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(300);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setThreadNamePrefix("test--");
        taskExecutor.initialize();
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 2; i++) {
            taskExecutor.execute(() -> {
                try {
                    PageHelper.startPage(5L, 1L);
                    t1Re.findAll();
                    PageHelper.pageInfo();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        for (int i = 0; i < 2; i++) {
            taskExecutor.execute(() -> {
                try {
                    PageHelper.startPage(5L, 1L);
                    t2Re.findAll();
                    PageHelper.pageInfo();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        for (int i = 0; i < 2; i++) {
            taskExecutor.execute(() -> {
                try {
                    PageHelper.startPage(5L, 1L);
                    t3Re.findAll();
                    PageHelper.pageInfo();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        for (int i = 0; i < 2; i++) {
            taskExecutor.execute(() -> {
                try {
                    PageHelper.startPage(5L, 1L);
                    t4Re.findAll();
                    PageHelper.pageInfo();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        for (int i = 0; i < 2; i++) {
            taskExecutor.execute(() -> {
                try {
                    PageHelper.startPage(5L, 1L);
                    t5Re.findAll();
                    PageHelper.pageInfo();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }
}
