package cn.yxtreme.jooq.temp;

import cn.yxtreme.jooq.jooq.tables.daos.ArrangementDao;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@Repository
public class T5Re extends ArrangementDao {
    private final DSLContext dslContext;

    public T5Re(DSLContext dslContext) {
        super(dslContext.configuration());
        this.dslContext = dslContext;
    }
}
