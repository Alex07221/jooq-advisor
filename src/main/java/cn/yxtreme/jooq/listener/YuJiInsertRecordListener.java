package cn.yxtreme.jooq.listener;

import cn.hutool.core.util.IdUtil;
import cn.yxtreme.jooq.model.BaseFieldConfig;
import cn.yxtreme.jooq.utils.Conditions;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class YuJiInsertRecordListener extends DefaultRecordListener {

    private final BaseFieldConfig.InsertField insertField;

    public YuJiInsertRecordListener(BaseFieldConfig.InsertField insertField) {
        this.insertField = insertField;
    }

    @Override
    public void insertStart(RecordContext ctx) {
        super.insertStart(ctx);
        Record record = ctx.record();
        Conditions.onFalse((Field<Long>) record.field(insertField.getId()), Objects::isNull
                , e -> Conditions.onFalse(e, Objects::isNull, t -> record.set(t, IdUtil.getSnowflake().nextId())));
        Conditions.onFalse((Field<LocalDateTime>) record.field(insertField.getCreated()), Objects::isNull
                , e -> Conditions.onFalse(e, Objects::isNull, t -> record.set(t, LocalDateTime.now())));
        Conditions.onFalse((Field<LocalDateTime>) record.field(insertField.getUpdated()), Objects::isNull
                , e -> Conditions.onFalse(e, Objects::isNull, t -> record.set(t, LocalDateTime.now())));
        Conditions.onFalse((Field<Integer>) record.field(insertField.getVersion()), Objects::isNull
                , e -> Conditions.onFalse(e, Objects::isNull, t -> record.set(t, 0)));
        Conditions.onFalse((Field<Boolean>) record.field(insertField.getDeleted()), Objects::isNull
                , e -> Conditions.onFalse(e, Objects::isNull, t -> record.set(t, false)));
    }

}
