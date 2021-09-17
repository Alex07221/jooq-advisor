/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables.records;


import cn.yxtreme.jooq.jooq.tables.MedicineOrderReceive;
import cn.yxtreme.jooq.jooq.tables.pojos.MedicineOrderReceivePO;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 订单表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MedicineOrderReceiveRecord extends UpdatableRecordImpl<MedicineOrderReceiveRecord> implements Record12<Long, LocalDateTime, Long, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.medicine_order_receive.id</code>. 主键id
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.id</code>. 主键id
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.medicine_order_receive.created_time</code>. 创建时间
     */
    public void setCreatedTime(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.created_time</code>. 创建时间
     */
    public LocalDateTime getCreatedTime() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.medicine_order_receive.medicine_order_id</code>.
     */
    public void setMedicineOrderId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.medicine_order_id</code>.
     */
    public Long getMedicineOrderId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_province</code>. 收货省份
     */
    public void setLgProvince(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_province</code>. 收货省份
     */
    public String getLgProvince() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_province_code</code>.
     * 收货省份 编码
     */
    public void setLgProvinceCode(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_province_code</code>.
     * 收货省份 编码
     */
    public String getLgProvinceCode() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_city</code>. 收件城市
     */
    public void setLgCity(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_city</code>. 收件城市
     */
    public String getLgCity() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_city_code</code>. 收件城市
     * 编码
     */
    public void setLgCityCode(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_city_code</code>. 收件城市
     * 编码
     */
    public String getLgCityCode() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_area</code>. 收货区
     */
    public void setLgArea(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_area</code>. 收货区
     */
    public String getLgArea() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_area_code</code>. 收货区
     * 编码
     */
    public void setLgAreaCode(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_area_code</code>. 收货区
     * 编码
     */
    public String getLgAreaCode() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_name</code>. 收货人
     */
    public void setLgName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_name</code>. 收货人
     */
    public String getLgName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_phone</code>. 收货手机
     */
    public void setLgPhone(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_phone</code>. 收货手机
     */
    public String getLgPhone() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.medicine_order_receive.lg_address</code>. 收货详细地址
     */
    public void setLgAddress(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.medicine_order_receive.lg_address</code>. 收货详细地址
     */
    public String getLgAddress() {
        return (String) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<Long, LocalDateTime, Long, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<Long, LocalDateTime, Long, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.CREATED_TIME;
    }

    @Override
    public Field<Long> field3() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.MEDICINE_ORDER_ID;
    }

    @Override
    public Field<String> field4() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_PROVINCE;
    }

    @Override
    public Field<String> field5() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_PROVINCE_CODE;
    }

    @Override
    public Field<String> field6() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_CITY;
    }

    @Override
    public Field<String> field7() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_CITY_CODE;
    }

    @Override
    public Field<String> field8() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_AREA;
    }

    @Override
    public Field<String> field9() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_AREA_CODE;
    }

    @Override
    public Field<String> field10() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_NAME;
    }

    @Override
    public Field<String> field11() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_PHONE;
    }

    @Override
    public Field<String> field12() {
        return MedicineOrderReceive.MEDICINE_ORDER_RECEIVE.LG_ADDRESS;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public LocalDateTime component2() {
        return getCreatedTime();
    }

    @Override
    public Long component3() {
        return getMedicineOrderId();
    }

    @Override
    public String component4() {
        return getLgProvince();
    }

    @Override
    public String component5() {
        return getLgProvinceCode();
    }

    @Override
    public String component6() {
        return getLgCity();
    }

    @Override
    public String component7() {
        return getLgCityCode();
    }

    @Override
    public String component8() {
        return getLgArea();
    }

    @Override
    public String component9() {
        return getLgAreaCode();
    }

    @Override
    public String component10() {
        return getLgName();
    }

    @Override
    public String component11() {
        return getLgPhone();
    }

    @Override
    public String component12() {
        return getLgAddress();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public LocalDateTime value2() {
        return getCreatedTime();
    }

    @Override
    public Long value3() {
        return getMedicineOrderId();
    }

    @Override
    public String value4() {
        return getLgProvince();
    }

    @Override
    public String value5() {
        return getLgProvinceCode();
    }

    @Override
    public String value6() {
        return getLgCity();
    }

    @Override
    public String value7() {
        return getLgCityCode();
    }

    @Override
    public String value8() {
        return getLgArea();
    }

    @Override
    public String value9() {
        return getLgAreaCode();
    }

    @Override
    public String value10() {
        return getLgName();
    }

    @Override
    public String value11() {
        return getLgPhone();
    }

    @Override
    public String value12() {
        return getLgAddress();
    }

    @Override
    public MedicineOrderReceiveRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value2(LocalDateTime value) {
        setCreatedTime(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value3(Long value) {
        setMedicineOrderId(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value4(String value) {
        setLgProvince(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value5(String value) {
        setLgProvinceCode(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value6(String value) {
        setLgCity(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value7(String value) {
        setLgCityCode(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value8(String value) {
        setLgArea(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value9(String value) {
        setLgAreaCode(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value10(String value) {
        setLgName(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value11(String value) {
        setLgPhone(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord value12(String value) {
        setLgAddress(value);
        return this;
    }

    @Override
    public MedicineOrderReceiveRecord values(Long value1, LocalDateTime value2, Long value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MedicineOrderReceiveRecord
     */
    public MedicineOrderReceiveRecord() {
        super(MedicineOrderReceive.MEDICINE_ORDER_RECEIVE);
    }

    /**
     * Create a detached, initialised MedicineOrderReceiveRecord
     */
    public MedicineOrderReceiveRecord(Long id, LocalDateTime createdTime, Long medicineOrderId, String lgProvince, String lgProvinceCode, String lgCity, String lgCityCode, String lgArea, String lgAreaCode, String lgName, String lgPhone, String lgAddress) {
        super(MedicineOrderReceive.MEDICINE_ORDER_RECEIVE);

        setId(id);
        setCreatedTime(createdTime);
        setMedicineOrderId(medicineOrderId);
        setLgProvince(lgProvince);
        setLgProvinceCode(lgProvinceCode);
        setLgCity(lgCity);
        setLgCityCode(lgCityCode);
        setLgArea(lgArea);
        setLgAreaCode(lgAreaCode);
        setLgName(lgName);
        setLgPhone(lgPhone);
        setLgAddress(lgAddress);
    }

    /**
     * Create a detached, initialised MedicineOrderReceiveRecord
     */
    public MedicineOrderReceiveRecord(MedicineOrderReceivePO value) {
        super(MedicineOrderReceive.MEDICINE_ORDER_RECEIVE);

        if (value != null) {
            setId(value.getId());
            setCreatedTime(value.getCreatedTime());
            setMedicineOrderId(value.getMedicineOrderId());
            setLgProvince(value.getLgProvince());
            setLgProvinceCode(value.getLgProvinceCode());
            setLgCity(value.getLgCity());
            setLgCityCode(value.getLgCityCode());
            setLgArea(value.getLgArea());
            setLgAreaCode(value.getLgAreaCode());
            setLgName(value.getLgName());
            setLgPhone(value.getLgPhone());
            setLgAddress(value.getLgAddress());
        }
    }
}
