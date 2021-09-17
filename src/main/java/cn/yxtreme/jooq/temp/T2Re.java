package cn.yxtreme.jooq.temp;

import cn.yxtreme.jooq.jooq.tables.daos.RegularUsageDao;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@Repository
public class T2Re extends RegularUsageDao {
    private final DSLContext dslContext;

    public T2Re(DSLContext dslContext) {
        super(dslContext.configuration());
        this.dslContext = dslContext;
    }
}
