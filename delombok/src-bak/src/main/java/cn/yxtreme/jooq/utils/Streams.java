package cn.yxtreme.jooq.utils;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: xuZeBiao
 * @since: 2021/7/20
 */
public class Streams {
    /**
     * stream语法糖，返回list
     *
     * @param e         需要处理的stream
     * @param function  stream的处理
     * @param function2 处理map映射
     * @return 处理成功的list
     */
    public static <E, R, T> List<T> streamToList(Stream<E> e, Function<Stream<E>, Stream<R>> function, Function<R, T> function2) {
        return function.apply(e).map(function2).collect(Collectors.toList());
    }

    /**
     * stream语法糖，分组
     *
     * @param e          需要处理的stream
     * @param function   stream的处理
     * @param classifier group的主键
     * @return 分组成功的结果
     */
    public static <E, R, U> Map<U, List<R>> streamGroup(Stream<E> e, Function<Stream<E>, Stream<R>> function, Function<R, U> classifier) {
        return function.apply(e).collect(Collectors.groupingBy(classifier::apply));
    }

    /**
     * stream语法糖，map
     *
     * @param e           需要处理的stream
     * @param function    stream的处理
     * @param classifier  map的主键
     * @param classifier2 map的值
     * @return 分组成功的结果
     */
    public static <E, R, U, T> Map<U, T> streamMap(Stream<E> e, Function<Stream<E>, Stream<R>> function, Function<R, U> classifier, Function<R, T> classifier2) {
        return function.apply(e).collect(Collectors.toMap(classifier::apply, classifier2::apply, (k1, k2) -> k1));
    }


    /**
     * stream语法糖，分组
     *
     * @param e           需要处理的stream
     * @param function    stream的处理
     * @param classifier  group的主键
     * @param classifier2 group的值
     * @return 分组成功的结果
     */
    public static <E, R, U, T> Map<U, List<T>> streamGroup(Stream<E> e, Function<Stream<E>, Stream<R>> function, Function<R, U> classifier, Function<R, T> classifier2) {
        return function.apply(e).collect(Collectors.groupingBy(classifier::apply, Collectors.mapping(classifier2, Collectors.toList())));
    }

    /**
     * stream语法糖，分组
     *
     * @param e           需要处理的stream
     * @param function    stream的处理
     * @param classifier  group的主键
     * @param classifier2 group的值
     * @return 分组成功的结果
     */
    public static <E, R, U, T> Map<U, List<T>> streamGroupByProperties(Stream<E> e, Function<E, R> function, Function<R, U> classifier, Function<R, T> classifier2) {
        return e.map(function).collect(Collectors.groupingBy(classifier::apply, Collectors.mapping(classifier2, Collectors.toList())));
    }

    /**
     * stream语法糖，分组
     *
     * @param e           需要处理的stream
     * @param function    stream的处理
     * @param classifier  group的主键
     * @param classifier2 group的值
     * @return 分组成功的结果
     */
    public static <E, R, U, T> Map<U, List<T>> streamGroupByProperties(Stream<E> e, Class<T> cla, BiFunction<E, Class<T>, R> function, Function<R, U> classifier, Function<R, T> classifier2) {
        return e.map(t -> function.apply(t, cla)).collect(Collectors.groupingBy(classifier::apply, Collectors.mapping(classifier2, Collectors.toList())));
    }

    /**
     * stream语法糖，分组
     *
     * @param e          需要处理的stream
     * @param function   stream的处理
     * @param classifier group的主键
     * @return 分组成功的结果
     */
    public static <E, R, U> Map<U, List<R>> streamGroupByProperties(Stream<E> e, Function<E, R> function, Function<R, U> classifier) {
        return e.map(function).collect(Collectors.groupingBy(classifier::apply));
    }

    /**
     * stream语法糖，分组
     *
     * @param e          需要处理的stream
     * @param function   stream的处理
     * @param classifier group的主键
     * @return 分组成功的结果
     */
    public static <E, R, U> Map<U, List<R>> streamGroupByProperties(Stream<E> e, Class<R> cla, BiFunction<E, Class<R>, R> function, Function<R, U> classifier) {
        return e.map(t -> function.apply(t, cla)).collect(Collectors.groupingBy(classifier::apply));
    }

}
