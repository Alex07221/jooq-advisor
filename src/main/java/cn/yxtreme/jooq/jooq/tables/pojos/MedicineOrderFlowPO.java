/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables.pojos;


import cn.yxtreme.jooq.model.BasePO;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * This class is generated by jOOQ.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Accessors(chain = true)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MedicineOrderFlowPO extends BasePO implements Serializable {

    private static final long serialVersionUID = 1L;

        private LocalDateTime createdTime;
        private Long          medicineOrderId;
        private Integer       orderStatus;
}
