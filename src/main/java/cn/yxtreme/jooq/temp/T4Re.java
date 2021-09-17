package cn.yxtreme.jooq.temp;

import cn.yxtreme.jooq.jooq.tables.daos.UsageDictionaryDao;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

/**
 * @author: Alex
 * @since: 2021/9/17
 */
@Repository
public class T4Re extends UsageDictionaryDao {
    private final DSLContext dslContext;

    public T4Re(DSLContext dslContext) {
        super(dslContext.configuration());
        this.dslContext = dslContext;
    }
}
