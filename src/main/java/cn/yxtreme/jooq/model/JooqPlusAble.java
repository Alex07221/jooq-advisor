package cn.yxtreme.jooq.model;

/**
 * It's mark to What JOOQ advisor can do
 *
 * @author: Alex
 * @since: 2021/8/10
 */
public enum JooqPlusAble {

    /**
     * all
     */
    ALL,

    /**
     * logic deleted
     */
    LOGIC_DELETE,

    /**
     * auto pagination
     */
    PAGEABLE,

    /**
     * join default value to insert
     */
    INSERT_DEFAULT,

    /**
     * join default value to update
     */
    UPDATE_DEFAULT
}
