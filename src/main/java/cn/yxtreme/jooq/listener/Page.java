package cn.yxtreme.jooq.listener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author admin
 */
@Getter
@ToString
@Setter
public final class Page {
    private Boolean doPage;
    private Long currentPage;
    private Long pageSize;
    private Long total;
    private Long pageTotal;
    private Long offset;
}
