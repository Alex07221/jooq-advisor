package cn.yxtreme.jooq.utils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: xuZeBiao
 * @since: 2021/7/20
 */
public class Conditions {

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 继续处理的方法
     * @return 处理成功的列表或者不通过返回空列表
     */
    public static final <T> void onFalse(T t, Function<T, Boolean> function1, Consumer<T> function2) {
        if (!function1.apply(t)) {
            function2.accept(t);
        }
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 继续处理的方法
     * @return 处理成功的列表或者不通过返回空列表
     */
    public static final <T> void onFalse(T t, Boolean function1, Consumer<T> function2) {
        if (!function1) {
            function2.accept(t);
        }
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Function<T, Boolean> function1, Function<T, R> function2, Function<T, R> function3) {
        return function1.apply(t) ? function2.apply(t) : function3.apply(t);
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Boolean function1, Function<T, R> function2, Function<T, R> function3) {
        return function1 ? function2.apply(t) : function3.apply(t);
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Function<T, Boolean> function1, Supplier<R> function2, Function<T, R> function3) {
        return function1.apply(t) ? function2.get() : function3.apply(t);
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Boolean function1, Supplier<R> function2, Function<T, R> function3) {
        return function1 ? function2.get() : function3.apply(t);
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Function<T, Boolean> function1, Function<T, R> function2, Supplier<R> function3) {
        return function1.apply(t) ? function2.apply(t) : function3.get();
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t,  Boolean function1, Function<T, R> function2, Supplier<R> function3) {
        return function1 ? function2.apply(t) : function3.get();
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Function<T, Boolean> function1, Consumer<T> function2, Function<T, R> function3) {
        if (function1.apply(t)) {
            function2.accept(t);
            return null;
        } else {
            return function3.apply(t);
        }
    }
    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Boolean function1, Consumer<T> function2, Function<T, R> function3) {
        if (function1) {
            function2.accept(t);
            return null;
        } else {
            return function3.apply(t);
        }
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T, R> R onCondition(T t, Function<T, Boolean> function1, Supplier<R> function2, Supplier<R> function3) {
        return function1.apply(t) ? function2.get() : function3.get();
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <R> R onCondition(Boolean function1, Supplier<R> function2, Supplier<R> function3) {
        return function1 ? function2.get() : function3.get();
    }

    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T> void onCondition(T t, Function<T, Boolean> function1, LeastConditionFunction function2, LeastConditionFunction function3) {
        if (function1.apply(t)){
            function2.doAction();
        }else {
            function3.doAction();
        }
    }



    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T> void onCondition(T t, Function<T, Boolean> function1, LeastConditionFunction function2, Consumer<T> function3) {
        if (function1.apply(t)){
            function2.doAction();
        }else {
            function3.accept(t);
        }
    }


    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T> void onCondition(T t, Function<T, Boolean> function1, Consumer<T> function2, Consumer<T> function3) {
        if (function1.apply(t)) {
            function2.accept(t);
        } else {
            function3.accept(t);
        }
    }


    /**
     * 简易链式结构，判断每一个步骤是否可以继续
     *
     * @param t         需要判断的值
     * @param function1 判断表达式
     * @param function2 判ture继续处理的方法
     * @param function3 判false继续处理的方法
     * @return 自定义返回值处理
     */
    public static final <T> void onCondition(T t, Boolean function1, Consumer<T> function2, Consumer<T> function3) {
        if (function1) {
            function2.accept(t);
        } else {
            function3.accept(t);
        }
    }


}
