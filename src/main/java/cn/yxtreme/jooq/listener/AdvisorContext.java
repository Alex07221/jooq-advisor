package cn.yxtreme.jooq.listener;


import java.util.Optional;

/**
 * @author: Alex
 * @since: 2021/7/19
 */
public class AdvisorContext {


    /**
     * 本次查询是否分页
     */
    /**
     * 本地缓存
     */
    private static final ThreadLocal<PageHelper> THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 开始分页
     *
     * @param pageSize
     * @param currentPage
     */
    synchronized static void startPage(Long pageSize, Long currentPage) {
        if (Optional.ofNullable(THREAD_LOCAL.get()).isPresent()) {
            return;
        }
        var page = new PageHelper();
        if (pageSize == null || currentPage == null || pageSize <= 0) {
            page.initPageInfo();
        } else {
            page.initPageInfo(pageSize, currentPage);
        }
        THREAD_LOCAL.set(page);
    }


    /**
     * 获取分页
     */
    static PageHelper getPageHelper() {
        return THREAD_LOCAL.get();
    }

    /**
     * 销毁缓存
     */
    synchronized static void destroyContext() {
        THREAD_LOCAL.remove();
    }

}
