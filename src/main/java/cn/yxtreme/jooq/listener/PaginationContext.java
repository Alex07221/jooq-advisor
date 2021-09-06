package cn.yxtreme.jooq.listener;


import java.util.HashMap;
import java.util.Map;

/**
 * @author: Alex
 * @since: 2021/7/19
 */
public class PaginationContext {


    /**
     * 本次查询是否分页
     */
    private static final String PAGE_INFO = "pageInfo";
    /**
     * 本地缓存
     */
    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = ThreadLocal.withInitial(() -> new HashMap<>(2));


    /**
     * 开始分页
     *
     * @param pageSize
     * @param currentPage
     */
    final static void startPage(Long pageSize, Long currentPage) {
        var page = PageHelper.acquireInstance();
        if (pageSize == null || currentPage == null || pageSize <= 0) {
            page.initPageInfo();
        } else {
            page.initPageInfo(pageSize, currentPage);
        }
        putMap(PAGE_INFO, page);
    }


    /**
     * 获取分页
     */
    final static PageHelper getPageHelper() {
        return (PageHelper) THREAD_LOCAL.get().get(PAGE_INFO);
    }

    /**
     * 销毁缓存
     */
    final static void destroyContext() {
        THREAD_LOCAL.remove();
    }

    /**
     * 为缓存设置值
     *
     * @param key
     * @param value
     */
    private final static void putMap(String key, Object value) {
        THREAD_LOCAL.get().put(key, value);
    }
}
