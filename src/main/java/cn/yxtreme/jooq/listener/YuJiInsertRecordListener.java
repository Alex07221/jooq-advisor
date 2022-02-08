package cn.yxtreme.jooq.listener;

import cn.hutool.core.util.IdUtil;
import cn.yxtreme.jooq.model.BaseFieldConfig;
import cn.yxtreme.jooq.utils.Conditions;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.RecordContext;
import org.jooq.impl.DefaultRecordListener;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author: xuZeBiao
 * @since: 2021/7/29
 */
public class YuJiInsertRecordListener extends DefaultRecordListener {
    @SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(YuJiInsertRecordListener.class);
    private final BaseFieldConfig.InsertField insertField;

    public YuJiInsertRecordListener(BaseFieldConfig.InsertField insertField) {
        this.insertField = insertField;
    }

    @Override
    public void insertStart(RecordContext ctx) {
        super.insertStart(ctx);
        Record record = ctx.record();
        try {
            Conditions.onFalse((Field<Long>) record.field(insertField.getId()), Objects::isNull, e -> Conditions.onFalse(e, t -> t.get(record) != null, t -> record.set(t, IdUtil.getSnowflake().nextId())));
            Conditions.onFalse((Field<LocalDateTime>) record.field(insertField.getCreated()), Objects::isNull, e -> Conditions.onFalse(e, t -> t.get(record) != null, t -> record.set(t, LocalDateTime.now())));
            Conditions.onFalse((Field<LocalDateTime>) record.field(insertField.getUpdated()), Objects::isNull, e -> Conditions.onFalse(e, t -> t.get(record) != null, t -> record.set(t, LocalDateTime.now())));
            Conditions.onFalse((Field<Integer>) record.field(insertField.getVersion()), Objects::isNull, e -> Conditions.onFalse(e, t -> t.get(record) != null, t -> record.set(t, 0)));
            Conditions.onFalse((Field<Boolean>) record.field(insertField.getDeleted()), Objects::isNull, e -> Conditions.onFalse(e, t -> t.get(record) != null, t -> record.set(t, false)));
        } catch (ClassCastException e) {
            log.warn("current table\'s fields have an not support type, please check and retry, cast error message: {}", e.getMessage());
        }
    }
}
