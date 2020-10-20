package com.test.model;

import lombok.Data;

/**
 * 链表结点
 * @author 崔航
 * @date 2020/10/20 13:54
 */
@Data
public class LinkedNode<T> {

    public LinkedNode<T> previous;

    public T value;

    public LinkedNode<T> next;

    public LinkedNode(T t) {
        this.value = t;
    }
}
