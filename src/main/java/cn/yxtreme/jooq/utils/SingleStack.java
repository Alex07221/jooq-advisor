package cn.yxtreme.jooq.utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * this kind of stack is used about only one element
 *
 * @author: Alex
 * @since: 2021/7/30
 */
public class SingleStack<T> {
    private final Deque<T> data;

    public SingleStack(T data) {
        this.data = new ArrayDeque<>();
        this.data.push(data);
    }

    public void pop() {
        stack().pop();
    }

    public synchronized void refresh(T t) {
        stack().pop();
        stack().push(t);
    }

    public Deque<T> stack() {
        return data;
    }

    public T data() {
        return stack().peek();
    }

}
