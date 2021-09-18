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
    private long currentPage;
    private long pageSize;
    private long total;
    private long pageTotal;
}
