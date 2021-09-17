/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables.daos;


import cn.yxtreme.jooq.jooq.tables.MedicineV2;
import cn.yxtreme.jooq.jooq.tables.pojos.MedicineV2PO;
import cn.yxtreme.jooq.jooq.tables.records.MedicineV2Record;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 开药表
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MedicineV2Dao extends DAOImpl<MedicineV2Record, MedicineV2PO, Long> {

    /**
     * Create a new MedicineV2Dao without any configuration
     */
    public MedicineV2Dao() {
        super(MedicineV2.MEDICINE_V2, MedicineV2PO.class);
    }

    /**
     * Create a new MedicineV2Dao with an attached configuration
     */
    public MedicineV2Dao(Configuration configuration) {
        super(MedicineV2.MEDICINE_V2, MedicineV2PO.class, configuration);
    }

    @Override
    public Long getId(MedicineV2PO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<MedicineV2PO> fetchById(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public MedicineV2PO fetchOneById(Long value) {
        return fetchOne(MedicineV2.MEDICINE_V2.ID, value);
    }

    /**
     * Fetch records that have <code>consult_order_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfConsultOrderId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.CONSULT_ORDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>consult_order_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByConsultOrderId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.CONSULT_ORDER_ID, values);
    }

    /**
     * Fetch records that have <code>created_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfCreatedTime(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.CREATED_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_time IN (values)</code>
     */
    public List<MedicineV2PO> fetchByCreatedTime(LocalDateTime... values) {
        return fetch(MedicineV2.MEDICINE_V2.CREATED_TIME, values);
    }

    /**
     * Fetch records that have <code>patient_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfPatientId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.PATIENT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>patient_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByPatientId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.PATIENT_ID, values);
    }

    /**
     * Fetch records that have <code>provider_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfProviderId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.PROVIDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>provider_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByProviderId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.PROVIDER_ID, values);
    }

    /**
     * Fetch records that have <code>assistant_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfAssistantId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.ASSISTANT_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>assistant_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByAssistantId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.ASSISTANT_ID, values);
    }

    /**
     * Fetch records that have <code>im_session_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfImSessionId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.IM_SESSION_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>im_session_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByImSessionId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.IM_SESSION_ID, values);
    }

    /**
     * Fetch records that have <code>leader_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfLeaderId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.LEADER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>leader_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByLeaderId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.LEADER_ID, values);
    }

    /**
     * Fetch records that have <code>pt_no BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfPtNo(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.PT_NO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>pt_no IN (values)</code>
     */
    public List<MedicineV2PO> fetchByPtNo(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.PT_NO, values);
    }

    /**
     * Fetch records that have <code>birthday BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfBirthday(LocalDate lowerInclusive, LocalDate upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.BIRTHDAY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>birthday IN (values)</code>
     */
    public List<MedicineV2PO> fetchByBirthday(LocalDate... values) {
        return fetch(MedicineV2.MEDICINE_V2.BIRTHDAY, values);
    }

    /**
     * Fetch records that have <code>sex BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfSex(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.SEX, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sex IN (values)</code>
     */
    public List<MedicineV2PO> fetchBySex(Integer... values) {
        return fetch(MedicineV2.MEDICINE_V2.SEX, values);
    }

    /**
     * Fetch records that have <code>department_name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfDepartmentName(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.DEPARTMENT_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>department_name IN (values)</code>
     */
    public List<MedicineV2PO> fetchByDepartmentName(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.DEPARTMENT_NAME, values);
    }

    /**
     * Fetch records that have <code>id_no BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfIdNo(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.ID_NO, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id_no IN (values)</code>
     */
    public List<MedicineV2PO> fetchByIdNo(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.ID_NO, values);
    }

    /**
     * Fetch records that have <code>complaint_content BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfComplaintContent(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.COMPLAINT_CONTENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>complaint_content IN (values)</code>
     */
    public List<MedicineV2PO> fetchByComplaintContent(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.COMPLAINT_CONTENT, values);
    }

    /**
     * Fetch records that have <code>diseaes_name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfDiseaesName(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.DISEAES_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>diseaes_name IN (values)</code>
     */
    public List<MedicineV2PO> fetchByDiseaesName(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.DISEAES_NAME, values);
    }

    /**
     * Fetch records that have <code>shop_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfShopId(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.SHOP_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>shop_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByShopId(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.SHOP_ID, values);
    }

    /**
     * Fetch records that have <code>pregnant BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfPregnant(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.PREGNANT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>pregnant IN (values)</code>
     */
    public List<MedicineV2PO> fetchByPregnant(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.PREGNANT, values);
    }

    /**
     * Fetch records that have <code>allergies BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfAllergies(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.ALLERGIES, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>allergies IN (values)</code>
     */
    public List<MedicineV2PO> fetchByAllergies(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.ALLERGIES, values);
    }

    /**
     * Fetch records that have <code>contraindications BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfContraindications(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.CONTRAINDICATIONS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>contraindications IN (values)</code>
     */
    public List<MedicineV2PO> fetchByContraindications(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.CONTRAINDICATIONS, values);
    }

    /**
     * Fetch records that have <code>weight BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfWeight(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.WEIGHT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>weight IN (values)</code>
     */
    public List<MedicineV2PO> fetchByWeight(BigDecimal... values) {
        return fetch(MedicineV2.MEDICINE_V2.WEIGHT, values);
    }

    /**
     * Fetch records that have <code>medicine_order_id BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfMedicineOrderId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.MEDICINE_ORDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>medicine_order_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByMedicineOrderId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.MEDICINE_ORDER_ID, values);
    }

    /**
     * Fetch records that have <code>is_usable BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfIsUsable(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.IS_USABLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_usable IN (values)</code>
     */
    public List<MedicineV2PO> fetchByIsUsable(Boolean... values) {
        return fetch(MedicineV2.MEDICINE_V2.IS_USABLE, values);
    }

    /**
     * Fetch records that have <code>id_card_type BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfIdCardType(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.ID_CARD_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id_card_type IN (values)</code>
     */
    public List<MedicineV2PO> fetchByIdCardType(Integer... values) {
        return fetch(MedicineV2.MEDICINE_V2.ID_CARD_TYPE, values);
    }

    /**
     * Fetch records that have <code>comments BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfComments(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.COMMENTS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>comments IN (values)</code>
     */
    public List<MedicineV2PO> fetchByComments(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.COMMENTS, values);
    }

    /**
     * Fetch records that have <code>prescription BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfPrescription(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.PRESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>prescription IN (values)</code>
     */
    public List<MedicineV2PO> fetchByPrescription(Boolean... values) {
        return fetch(MedicineV2.MEDICINE_V2.PRESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>forward BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfForward(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.FORWARD, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>forward IN (values)</code>
     */
    public List<MedicineV2PO> fetchByForward(Boolean... values) {
        return fetch(MedicineV2.MEDICINE_V2.FORWARD, values);
    }

    /**
     * Fetch records that have <code>forward_user_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfForwardUserId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.FORWARD_USER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>forward_user_id IN (values)</code>
     */
    public List<MedicineV2PO> fetchByForwardUserId(Long... values) {
        return fetch(MedicineV2.MEDICINE_V2.FORWARD_USER_ID, values);
    }

    /**
     * Fetch records that have <code>forward_department BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfForwardDepartment(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.FORWARD_DEPARTMENT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>forward_department IN (values)</code>
     */
    public List<MedicineV2PO> fetchByForwardDepartment(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.FORWARD_DEPARTMENT, values);
    }

    /**
     * Fetch records that have <code>doctor_name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfDoctorName(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.DOCTOR_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>doctor_name IN (values)</code>
     */
    public List<MedicineV2PO> fetchByDoctorName(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.DOCTOR_NAME, values);
    }

    /**
     * Fetch records that have <code>forward_user_name BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfForwardUserName(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.FORWARD_USER_NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>forward_user_name IN (values)</code>
     */
    public List<MedicineV2PO> fetchByForwardUserName(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.FORWARD_USER_NAME, values);
    }

    /**
     * Fetch records that have <code>prescription_base64 BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfPrescriptionBase64(String lowerInclusive, String upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.PRESCRIPTION_BASE64, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>prescription_base64 IN (values)</code>
     */
    public List<MedicineV2PO> fetchByPrescriptionBase64(String... values) {
        return fetch(MedicineV2.MEDICINE_V2.PRESCRIPTION_BASE64, values);
    }

    /**
     * Fetch records that have <code>shop_type BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<MedicineV2PO> fetchRangeOfShopType(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(MedicineV2.MEDICINE_V2.SHOP_TYPE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>shop_type IN (values)</code>
     */
    public List<MedicineV2PO> fetchByShopType(Integer... values) {
        return fetch(MedicineV2.MEDICINE_V2.SHOP_TYPE, values);
    }
        public List<MedicineV2PO> fetchById(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByConsultOrderId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.CONSULT_ORDER_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByCreatedTime(Collection<LocalDateTime> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.CREATED_TIME, value.toArray(new LocalDateTime[value.size()]));
        }
        public List<MedicineV2PO> fetchByPatientId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.PATIENT_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByProviderId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.PROVIDER_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByAssistantId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.ASSISTANT_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByImSessionId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.IM_SESSION_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByLeaderId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.LEADER_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByPtNo(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.PT_NO, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByBirthday(Collection<LocalDate> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.BIRTHDAY, value.toArray(new LocalDate[value.size()]));
        }
        public List<MedicineV2PO> fetchBySex(Collection<Integer> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.SEX, value.toArray(new Integer[value.size()]));
        }
        public List<MedicineV2PO> fetchByDepartmentName(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.DEPARTMENT_NAME, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByIdNo(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.ID_NO, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByComplaintContent(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.COMPLAINT_CONTENT, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByDiseaesName(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.DISEAES_NAME, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByShopId(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.SHOP_ID, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByPregnant(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.PREGNANT, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByAllergies(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.ALLERGIES, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByContraindications(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.CONTRAINDICATIONS, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByWeight(Collection<BigDecimal> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.WEIGHT, value.toArray(new BigDecimal[value.size()]));
        }
        public List<MedicineV2PO> fetchByMedicineOrderId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.MEDICINE_ORDER_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByIsUsable(Collection<Boolean> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.IS_USABLE, value.toArray(new Boolean[value.size()]));
        }
        public List<MedicineV2PO> fetchByIdCardType(Collection<Integer> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.ID_CARD_TYPE, value.toArray(new Integer[value.size()]));
        }
        public List<MedicineV2PO> fetchByComments(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.COMMENTS, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByPrescription(Collection<Boolean> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.PRESCRIPTION, value.toArray(new Boolean[value.size()]));
        }
        public List<MedicineV2PO> fetchByForward(Collection<Boolean> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.FORWARD, value.toArray(new Boolean[value.size()]));
        }
        public List<MedicineV2PO> fetchByForwardUserId(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.FORWARD_USER_ID, value.toArray(new Long[value.size()]));
        }
        public List<MedicineV2PO> fetchByForwardDepartment(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.FORWARD_DEPARTMENT, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByDoctorName(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.DOCTOR_NAME, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByForwardUserName(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.FORWARD_USER_NAME, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByPrescriptionBase64(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.PRESCRIPTION_BASE64, value.toArray(new String[value.size()]));
        }
        public List<MedicineV2PO> fetchByShopType(Collection<Integer> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.MedicineV2.MEDICINE_V2.SHOP_TYPE, value.toArray(new Integer[value.size()]));
        }
}
