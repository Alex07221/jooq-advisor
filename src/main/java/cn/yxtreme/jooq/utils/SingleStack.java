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

    public static <T> SingleStack<T> provideStack(SingleStack<T> singleStack, T data) {
        return singleStack != null && singleStack.hasElement() ? singleStack : new SingleStack(data);
    }

    public SingleStack(T data) {
        this.data = new ArrayDeque<>();
        this.data.push(data);
    }

    public void pop() {
        if (stack().size() > 0) {
            stack().pop();
        }
    }

    public boolean hasElement() {
        return stack().size() > 0;
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
