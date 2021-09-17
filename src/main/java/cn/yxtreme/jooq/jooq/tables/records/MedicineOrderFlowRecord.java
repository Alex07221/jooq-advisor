/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables.records;


import cn.yxtreme.jooq.jooq.tables.MedicineOrderFlow;
import cn.yxtreme.jooq.jooq.tables.pojos.MedicineOrderFlowPO;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MedicineOrderFlowRecord extends UpdatableRecordImpl<MedicineOrderFlowRecord> implements Record4<Long, LocalDateTime, Long, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.medicine_order_flow.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.medicine_order_flow.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.medicine_order_flow.created_time</code>.
     */
    public void setCreatedTime(LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.medicine_order_flow.created_time</code>.
     */
    public LocalDateTime getCreatedTime() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.medicine_order_flow.medicine_order_id</code>.
     */
    public void setMedicineOrderId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.medicine_order_flow.medicine_order_id</code>.
     */
    public Long getMedicineOrderId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.medicine_order_flow.order_status</code>.
     */
    public void setOrderStatus(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.medicine_order_flow.order_status</code>.
     */
    public Integer getOrderStatus() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, LocalDateTime, Long, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, LocalDateTime, Long, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MedicineOrderFlow.MEDICINE_ORDER_FLOW.ID;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return MedicineOrderFlow.MEDICINE_ORDER_FLOW.CREATED_TIME;
    }

    @Override
    public Field<Long> field3() {
        return MedicineOrderFlow.MEDICINE_ORDER_FLOW.MEDICINE_ORDER_ID;
    }

    @Override
    public Field<Integer> field4() {
        return MedicineOrderFlow.MEDICINE_ORDER_FLOW.ORDER_STATUS;
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
    public Integer component4() {
        return getOrderStatus();
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
    public Integer value4() {
        return getOrderStatus();
    }

    @Override
    public MedicineOrderFlowRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MedicineOrderFlowRecord value2(LocalDateTime value) {
        setCreatedTime(value);
        return this;
    }

    @Override
    public MedicineOrderFlowRecord value3(Long value) {
        setMedicineOrderId(value);
        return this;
    }

    @Override
    public MedicineOrderFlowRecord value4(Integer value) {
        setOrderStatus(value);
        return this;
    }

    @Override
    public MedicineOrderFlowRecord values(Long value1, LocalDateTime value2, Long value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MedicineOrderFlowRecord
     */
    public MedicineOrderFlowRecord() {
        super(MedicineOrderFlow.MEDICINE_ORDER_FLOW);
    }

    /**
     * Create a detached, initialised MedicineOrderFlowRecord
     */
    public MedicineOrderFlowRecord(Long id, LocalDateTime createdTime, Long medicineOrderId, Integer orderStatus) {
        super(MedicineOrderFlow.MEDICINE_ORDER_FLOW);

        setId(id);
        setCreatedTime(createdTime);
        setMedicineOrderId(medicineOrderId);
        setOrderStatus(orderStatus);
    }

    /**
     * Create a detached, initialised MedicineOrderFlowRecord
     */
    public MedicineOrderFlowRecord(MedicineOrderFlowPO value) {
        super(MedicineOrderFlow.MEDICINE_ORDER_FLOW);

        if (value != null) {
            setId(value.getId());
            setCreatedTime(value.getCreatedTime());
            setMedicineOrderId(value.getMedicineOrderId());
            setOrderStatus(value.getOrderStatus());
        }
    }
}
