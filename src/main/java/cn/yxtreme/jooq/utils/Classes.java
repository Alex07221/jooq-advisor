package cn.yxtreme.jooq.utils;

import java.lang.reflect.Field;

/**
 * 反射工具类
 *
 * @author: xuZeBiao
 * @since: 2021/8/2
 */
public class Classes {

    /**
     * 获取属性值
     *
     * @param obj
     * @param fieldName
     * @return
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Class<?> aClass = obj.getClass();
            Field field = aClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 对比类型
     *
     * @param obj
     * @param className
     * @return
     */
    public static Boolean compareTypeByName(Object obj, String className) {
        try {
            return obj.getClass().equals(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
