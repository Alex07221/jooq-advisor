/*
 * This file is generated by jOOQ.
 */
package cn.yxtreme.jooq.jooq.tables;


import cn.yxtreme.jooq.jooq.Indexes;
import cn.yxtreme.jooq.jooq.Keys;
import cn.yxtreme.jooq.jooq.Public;
import cn.yxtreme.jooq.jooq.tables.records.UsageDictionaryRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsageDictionary extends TableImpl<UsageDictionaryRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.usage_dictionary</code>
     */
    public static final UsageDictionary USAGE_DICTIONARY = new UsageDictionary();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsageDictionaryRecord> getRecordType() {
        return UsageDictionaryRecord.class;
    }

    /**
     * The column <code>public.usage_dictionary.id</code>.
     */
    public final TableField<UsageDictionaryRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.usage_dictionary.concept</code>.
     */
    public final TableField<UsageDictionaryRecord, String> CONCEPT = createField(DSL.name("concept"), SQLDataType.VARCHAR(16).nullable(false), this, "");

    /**
     * The column <code>public.usage_dictionary.key</code>.
     */
    public final TableField<UsageDictionaryRecord, String> KEY = createField(DSL.name("key"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.usage_dictionary.value</code>.
     */
    public final TableField<UsageDictionaryRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.usage_dictionary.deleted</code>.
     */
    public final TableField<UsageDictionaryRecord, Boolean> DELETED = createField(DSL.name("deleted"), SQLDataType.BOOLEAN.defaultValue(DSL.field("false", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.usage_dictionary.created</code>.
     */
    public final TableField<UsageDictionaryRecord, LocalDateTime> CREATED = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.usage_dictionary.updated</code>.
     */
    public final TableField<UsageDictionaryRecord, LocalDateTime> UPDATED = createField(DSL.name("updated"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.usage_dictionary.version</code>.
     */
    public final TableField<UsageDictionaryRecord, Integer> VERSION = createField(DSL.name("version"), SQLDataType.INTEGER.defaultValue(DSL.field("0", SQLDataType.INTEGER)), this, "");

    private UsageDictionary(Name alias, Table<UsageDictionaryRecord> aliased) {
        this(alias, aliased, null);
    }

    private UsageDictionary(Name alias, Table<UsageDictionaryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.usage_dictionary</code> table reference
     */
    public UsageDictionary(String alias) {
        this(DSL.name(alias), USAGE_DICTIONARY);
    }

    /**
     * Create an aliased <code>public.usage_dictionary</code> table reference
     */
    public UsageDictionary(Name alias) {
        this(alias, USAGE_DICTIONARY);
    }

    /**
     * Create a <code>public.usage_dictionary</code> table reference
     */
    public UsageDictionary() {
        this(DSL.name("usage_dictionary"), null);
    }

    public <O extends Record> UsageDictionary(Table<O> child, ForeignKey<O, UsageDictionaryRecord> key) {
        super(child, key, USAGE_DICTIONARY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.USAGE_DICTIONARY_CONCEPT_KEY_IDX);
    }

    @Override
    public Identity<UsageDictionaryRecord, Long> getIdentity() {
        return (Identity<UsageDictionaryRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<UsageDictionaryRecord> getPrimaryKey() {
        return Keys.USAGE_DICTIONARY_PKEY;
    }

    @Override
    public UsageDictionary as(String alias) {
        return new UsageDictionary(DSL.name(alias), this);
    }

    @Override
    public UsageDictionary as(Name alias) {
        return new UsageDictionary(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UsageDictionary rename(String name) {
        return new UsageDictionary(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UsageDictionary rename(Name name) {
        return new UsageDictionary(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, String, String, String, Boolean, LocalDateTime, LocalDateTime, Integer> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
