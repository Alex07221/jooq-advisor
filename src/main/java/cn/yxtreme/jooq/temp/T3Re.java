package cn.yxtreme.jooq.temp;

import cn.yxtreme.jooq.jooq.tables.daos.RegularUsageCountDao;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@Repository
public class T3Re extends RegularUsageCountDao {
    private final DSLContext dslContext;

    public T3Re(DSLContext dslContext) {
        super(dslContext.configuration());
        this.dslContext = dslContext;
    }
}
