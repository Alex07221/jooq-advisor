package cn.yxtreme.jooq.temp;

import cn.yxtreme.jooq.jooq.tables.daos.OrderDao;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@Repository
public class T1Re extends OrderDao {
    private final DSLContext dslContext;

    public T1Re(DSLContext dslContext) {
        super(dslContext.configuration());
        this.dslContext = dslContext;
    }
}
