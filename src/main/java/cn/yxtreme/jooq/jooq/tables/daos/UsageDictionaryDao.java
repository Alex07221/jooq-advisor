/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables.daos;


import cn.yxtreme.jooq.jooq.tables.UsageDictionary;
import cn.yxtreme.jooq.jooq.tables.pojos.UsageDictionaryPO;
import cn.yxtreme.jooq.jooq.tables.records.UsageDictionaryRecord;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsageDictionaryDao extends DAOImpl<UsageDictionaryRecord, UsageDictionaryPO, Long> {

    /**
     * Create a new UsageDictionaryDao without any configuration
     */
    public UsageDictionaryDao() {
        super(UsageDictionary.USAGE_DICTIONARY, UsageDictionaryPO.class);
    }

    /**
     * Create a new UsageDictionaryDao with an attached configuration
     */
    public UsageDictionaryDao(Configuration configuration) {
        super(UsageDictionary.USAGE_DICTIONARY, UsageDictionaryPO.class, configuration);
    }

    @Override
    public Long getId(UsageDictionaryPO object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchById(Long... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public UsageDictionaryPO fetchOneById(Long value) {
        return fetchOne(UsageDictionary.USAGE_DICTIONARY.ID, value);
    }

    /**
     * Fetch records that have <code>concept BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfConcept(String lowerInclusive, String upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.CONCEPT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>concept IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByConcept(String... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.CONCEPT, values);
    }

    /**
     * Fetch records that have <code>key BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfKey(String lowerInclusive, String upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.KEY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>key IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByKey(String... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.KEY, values);
    }

    /**
     * Fetch records that have <code>value BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfValue(String lowerInclusive, String upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.VALUE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>value IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByValue(String... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.VALUE, values);
    }

    /**
     * Fetch records that have <code>deleted BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfDeleted(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>deleted IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByDeleted(Boolean... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.DELETED, values);
    }

    /**
     * Fetch records that have <code>created BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfCreated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.CREATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByCreated(LocalDateTime... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.CREATED, values);
    }

    /**
     * Fetch records that have <code>updated BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfUpdated(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.UPDATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByUpdated(LocalDateTime... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.UPDATED, values);
    }

    /**
     * Fetch records that have <code>version BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<UsageDictionaryPO> fetchRangeOfVersion(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(UsageDictionary.USAGE_DICTIONARY.VERSION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>version IN (values)</code>
     */
    public List<UsageDictionaryPO> fetchByVersion(Integer... values) {
        return fetch(UsageDictionary.USAGE_DICTIONARY.VERSION, values);
    }
        public List<UsageDictionaryPO> fetchById(Collection<Long> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.ID, value.toArray(new Long[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByConcept(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.CONCEPT, value.toArray(new String[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByKey(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.KEY, value.toArray(new String[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByValue(Collection<String> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.VALUE, value.toArray(new String[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByDeleted(Collection<Boolean> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.DELETED, value.toArray(new Boolean[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByCreated(Collection<LocalDateTime> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.CREATED, value.toArray(new LocalDateTime[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByUpdated(Collection<LocalDateTime> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.UPDATED, value.toArray(new LocalDateTime[value.size()]));
        }
        public List<UsageDictionaryPO> fetchByVersion(Collection<Integer> value) {
                return fetch(cn.yxtreme.jooq.jooq.tables.UsageDictionary.USAGE_DICTIONARY.VERSION, value.toArray(new Integer[value.size()]));
        }
}
