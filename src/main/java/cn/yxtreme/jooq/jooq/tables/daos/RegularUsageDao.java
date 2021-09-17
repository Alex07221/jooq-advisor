/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables.daos;


import cn.yxtreme.jooq.jooq.tables.RegularUsage;
import cn.yxtreme.jooq.jooq.tables.pojos.RegularUsagePO;
import cn.yxtreme.jooq.jooq.tables.records.RegularUsageRecord;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RegularUsageDao extends DAOImpl<RegularUsageRecord, RegularUsagePO, Long> {

    /**
     * Create a new RegularUsageDao without any configuration
     */
    public RegularUsageDao() {
        super(RegularUsage.REGULAR_USAGE, RegularUsagePO.class);
    }

    /**
     * Create a new RegularUsageDao with an attached configuration
     */
    public RegularUsageDao(Configuration configuration) {
        super(RegularUsage.REGULAR_USAGE, RegularUsagePO.class, configuration);
    }

    @Override
    public Long getId(RegularUsagePO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<RegularUsagePO> fetchById(Long... values) {
        return fetch(RegularUsage.REGULAR_USAGE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public RegularUsagePO fetchOneById(Long value) {
        return fetchOne(RegularUsage.REGULAR_USAGE.ID, value);
    }

    /**
     * Fetch records that have <code>usage BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfUsage(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.USAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>usage IN (values)</code>
     */
    public List<RegularUsagePO> fetchByUsage(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.USAGE, values);
    }

    /**
     * Fetch records that have <code>dosage BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfDosage(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.DOSAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dosage IN (values)</code>
     */
    public List<RegularUsagePO> fetchByDosage(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.DOSAGE, values);
    }

    /**
     * Fetch records that have <code>sku BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfSku(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.SKU, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>sku IN (values)</code>
     */
    public List<RegularUsagePO> fetchBySku(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.SKU, values);
    }

    /**
     * Fetch records that have <code>usage_unit BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfUsageUnit(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.USAGE_UNIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>usage_unit IN (values)</code>
     */
    public List<RegularUsagePO> fetchByUsageUnit(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.USAGE_UNIT, values);
    }

    /**
     * Fetch records that have <code>use_time BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfUseTime(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.USE_TIME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>use_time IN (values)</code>
     */
    public List<RegularUsagePO> fetchByUseTime(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.USE_TIME, values);
    }

    /**
     * Fetch records that have <code>use_time_unit BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfUseTimeUnit(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.USE_TIME_UNIT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>use_time_unit IN (values)</code>
     */
    public List<RegularUsagePO> fetchByUseTimeUnit(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.USE_TIME_UNIT, values);
    }

    /**
     * Fetch records that have <code>adverse_reactions BETWEEN lowerInclusive
     * AND upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfAdverseReactions(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.ADVERSE_REACTIONS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>adverse_reactions IN (values)</code>
     */
    public List<RegularUsagePO> fetchByAdverseReactions(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.ADVERSE_REACTIONS, values);
    }

    /**
     * Fetch records that have <code>forbiddance BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfForbiddance(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.FORBIDDANCE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>forbiddance IN (values)</code>
     */
    public List<RegularUsagePO> fetchByForbiddance(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.FORBIDDANCE, values);
    }

    /**
     * Fetch records that have <code>attention BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfAttention(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.ATTENTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>attention IN (values)</code>
     */
    public List<RegularUsagePO> fetchByAttention(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.ATTENTION, values);
    }

    /**
     * Fetch records that have <code>interaction BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfInteraction(String lowerInclusive, String upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.INTERACTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>interaction IN (values)</code>
     */
    public List<RegularUsagePO> fetchByInteraction(String... values) {
        return fetch(RegularUsage.REGULAR_USAGE.INTERACTION, values);
    }

    /**
     * Fetch records that have <code>deleted BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfDeleted(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>deleted IN (values)</code>
     */
    public List<RegularUsagePO> fetchByDeleted(Boolean... values) {
        return fetch(RegularUsage.REGULAR_USAGE.DELETED, values);
    }

    /**
     * Fetch records that have <code>created BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfCreated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.CREATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<RegularUsagePO> fetchByCreated(LocalDateTime... values) {
        return fetch(RegularUsage.REGULAR_USAGE.CREATED, values);
    }

    /**
     * Fetch records that have <code>updated BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfUpdated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.UPDATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated IN (values)</code>
     */
    public List<RegularUsagePO> fetchByUpdated(LocalDateTime... values) {
        return fetch(RegularUsage.REGULAR_USAGE.UPDATED, values);
    }

    /**
     * Fetch records that have <code>version BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<RegularUsagePO> fetchRangeOfVersion(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RegularUsage.REGULAR_USAGE.VERSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>version IN (values)</code>
     */
    public List<RegularUsagePO> fetchByVersion(Integer... values) {
        return fetch(RegularUsage.REGULAR_USAGE.VERSION, values);
    }
        public List<RegularUsagePO> fetchById(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.ID, value.toArray(new Long[value.size()]));
        }
        public List<RegularUsagePO> fetchByUsage(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.USAGE, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByDosage(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.DOSAGE, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchBySku(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.SKU, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByUsageUnit(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.USAGE_UNIT, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByUseTime(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.USE_TIME, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByUseTimeUnit(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.USE_TIME_UNIT, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByAdverseReactions(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.ADVERSE_REACTIONS, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByForbiddance(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.FORBIDDANCE, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByAttention(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.ATTENTION, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByInteraction(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.INTERACTION, value.toArray(new String[value.size()]));
        }
        public List<RegularUsagePO> fetchByDeleted(Collection<Boolean> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.DELETED, value.toArray(new Boolean[value.size()]));
        }
        public List<RegularUsagePO> fetchByCreated(Collection<LocalDateTime> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.CREATED, value.toArray(new LocalDateTime[value.size()]));
        }
        public List<RegularUsagePO> fetchByUpdated(Collection<LocalDateTime> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.UPDATED, value.toArray(new LocalDateTime[value.size()]));
        }
        public List<RegularUsagePO> fetchByVersion(Collection<Integer> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.RegularUsage.REGULAR_USAGE.VERSION, value.toArray(new Integer[value.size()]));
        }
}
