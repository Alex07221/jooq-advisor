/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables;


import cn.yxtreme.jooq.jooq.Keys;
import cn.yxtreme.jooq.jooq.Public;
import cn.yxtreme.jooq.jooq.tables.records.MedicineOrderReceiveRecord;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row12;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * 订单表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MedicineOrderReceive extends TableImpl<MedicineOrderReceiveRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.medicine_order_receive</code>
     */
    public static final MedicineOrderReceive MEDICINE_ORDER_RECEIVE = new MedicineOrderReceive();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MedicineOrderReceiveRecord> getRecordType() {
        return MedicineOrderReceiveRecord.class;
    }

    /**
     * The column <code>public.medicine_order_receive.id</code>. 主键id
     */
    public final TableField<MedicineOrderReceiveRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "主键id");

    /**
     * The column <code>public.medicine_order_receive.created_time</code>. 创建时间
     */
    public final TableField<MedicineOrderReceiveRecord, LocalDateTime> CREATED_TIME = createField(DSL.name("created_time"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("CURRENT_TIMESTAMP(0)", SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>public.medicine_order_receive.medicine_order_id</code>.
     */
    public final TableField<MedicineOrderReceiveRecord, Long> MEDICINE_ORDER_ID = createField(DSL.name("medicine_order_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.medicine_order_receive.lg_province</code>. 收货省份
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_PROVINCE = createField(DSL.name("lg_province"), SQLDataType.VARCHAR, this, "收货省份");

    /**
     * The column <code>public.medicine_order_receive.lg_province_code</code>.
     * 收货省份 编码
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_PROVINCE_CODE = createField(DSL.name("lg_province_code"), SQLDataType.VARCHAR, this, "收货省份 编码");

    /**
     * The column <code>public.medicine_order_receive.lg_city</code>. 收件城市
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_CITY = createField(DSL.name("lg_city"), SQLDataType.VARCHAR, this, "收件城市");

    /**
     * The column <code>public.medicine_order_receive.lg_city_code</code>. 收件城市
     * 编码
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_CITY_CODE = createField(DSL.name("lg_city_code"), SQLDataType.VARCHAR, this, "收件城市 编码");

    /**
     * The column <code>public.medicine_order_receive.lg_area</code>. 收货区
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_AREA = createField(DSL.name("lg_area"), SQLDataType.VARCHAR, this, "收货区");

    /**
     * The column <code>public.medicine_order_receive.lg_area_code</code>. 收货区
     * 编码
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_AREA_CODE = createField(DSL.name("lg_area_code"), SQLDataType.VARCHAR, this, "收货区 编码");

    /**
     * The column <code>public.medicine_order_receive.lg_name</code>. 收货人
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_NAME = createField(DSL.name("lg_name"), SQLDataType.VARCHAR, this, "收货人");

    /**
     * The column <code>public.medicine_order_receive.lg_phone</code>. 收货手机
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_PHONE = createField(DSL.name("lg_phone"), SQLDataType.VARCHAR, this, "收货手机");

    /**
     * The column <code>public.medicine_order_receive.lg_address</code>. 收货详细地址
     */
    public final TableField<MedicineOrderReceiveRecord, String> LG_ADDRESS = createField(DSL.name("lg_address"), SQLDataType.VARCHAR, this, "收货详细地址");

    private MedicineOrderReceive(Name alias, Table<MedicineOrderReceiveRecord> aliased) {
        this(alias, aliased, null);
    }

    private MedicineOrderReceive(Name alias, Table<MedicineOrderReceiveRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("订单表"), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.medicine_order_receive</code> table
     * reference
     */
    public MedicineOrderReceive(String alias) {
        this(DSL.name(alias), MEDICINE_ORDER_RECEIVE);
    }

    /**
     * Create an aliased <code>public.medicine_order_receive</code> table
     * reference
     */
    public MedicineOrderReceive(Name alias) {
        this(alias, MEDICINE_ORDER_RECEIVE);
    }

    /**
     * Create a <code>public.medicine_order_receive</code> table reference
     */
    public MedicineOrderReceive() {
        this(DSL.name("medicine_order_receive"), null);
    }

    public <O extends Record> MedicineOrderReceive(Table<O> child, ForeignKey<O, MedicineOrderReceiveRecord> key) {
        super(child, key, MEDICINE_ORDER_RECEIVE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<MedicineOrderReceiveRecord, Long> getIdentity() {
        return (Identity<MedicineOrderReceiveRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<MedicineOrderReceiveRecord> getPrimaryKey() {
        return Keys.MEDICINE_ORDER_RECEIVE_PKEY;
    }

    @Override
    public MedicineOrderReceive as(String alias) {
        return new MedicineOrderReceive(DSL.name(alias), this);
    }

    @Override
    public MedicineOrderReceive as(Name alias) {
        return new MedicineOrderReceive(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MedicineOrderReceive rename(String name) {
        return new MedicineOrderReceive(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MedicineOrderReceive rename(Name name) {
        return new MedicineOrderReceive(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<Long, LocalDateTime, Long, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}
