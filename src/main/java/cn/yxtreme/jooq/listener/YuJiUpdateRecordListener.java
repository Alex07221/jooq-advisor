package cn.yxtreme.jooq.listener;

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
public class YuJiUpdateRecordListener extends DefaultRecordListener {

    private final BaseFieldConfig.UpdateField updateField;

    public YuJiUpdateRecordListener(BaseFieldConfig.UpdateField updateField) {
        this.updateField = updateField;
    }

    @Override
    public void updateStart(RecordContext ctx) {
        super.updateStart(ctx);
        Record record = ctx.record();
        try {
            Conditions.onFalse((Field<LocalDateTime>) record.field(updateField.getUpdated()), Objects::isNull
                    , e -> Conditions.onFalse(e, Objects::isNull, t -> record.set(t, LocalDateTime.now())));
        } catch (ClassCastException e) {
            log.warn("current table's fields have an not support type, please check and retry, cast error message: {}", e.getMessage());
        }
    }
}
