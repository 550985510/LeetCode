package com.test.list.linked;

import com.test.model.LinkedNode;
import lombok.Data;

/**
 * 手写双向链表
 * @author 崔航
 * @date 2020/10/20 13:49
 */
@Data
public class MyLinkedList<T> {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list.get(1));
        list.add("ddd");
        System.out.println(list.get(2));
        list.add(2, "bbb");
        System.out.println(list.get(2));
    }

    LinkedNode<T> first;

    LinkedNode<T> last;

    int size;

    /**
     * 向列表的尾部添加值
     * @param t 值
     */
    public void add(T t) {
        LinkedNode<T> node = new LinkedNode<T>(t);
        if (null == first) {
            //如果列表为空没有头结点 则自己是头结点
            first = node;
        } else {
            //尾结点的下一个结点指向自己（添加到尾结点后面）
            last.next = node;
            //自己的上一个结点指向尾结点
            node.previous = last;
        }
        //自己成为尾结点
        last = node;
        size++;
    }

    /**
     * 在指定位置添加值
     * @param index 指定位置
     * @param t 新增的值
     */
    public void add(int index, T t) {
        this.checkPositionIndex(index);
        final LinkedNode<T> node = new LinkedNode<T>(t);
        if (index == size) {
            //在尾结点后面添加结点
            //自己的上一个结点指向尾结点
            node.previous = last;
            //尾结点的下一个结点指向自己
            last.next = node;
            //自己成为尾结点
            last = node;
        } else {
            //在index位置添加结点 获取index位置原有结点
            LinkedNode<T> oldNode = node(index);
            if (null == oldNode.previous) {
                //原有结点的上一个结点如果为空 则原有结点是头结点 也是 尾结点
                first = node;
            } else {
                //原有结点的上一个结点的next指向自己
                oldNode.previous.next = node;
            }
            //自己的previous结点指向原因结点的previous
            node.previous = oldNode.previous;
            //原有结点的previous指向自己
            oldNode.previous = node;
            //自己的next指向原有结点
            node.next = oldNode;
        }
        size++;

    }

    /**
     * 删除指定位置的元素
     * @param index 指定位置
     */
    public void remove(int index) {
        this.checkElementIndex(index);
        LinkedNode<T> node = node(index);
        final LinkedNode<T> next = node.next;
        final LinkedNode<T> previous = node.previous;

        if (null == previous) {
            //自己的上一个结点为空 则自己为头元素 将头结点改为自己的下一个结点
            first = next;
        } else {
            //自己的上一个结点的next指向自己的下一个结点
            previous.next = next;
            //自己的上一个指针移除
            node.previous = null;
        }

        if (null == next) {
            //自己的下一个结点为空 则自己是尾结点 将尾结点改为自己的上一个结点
            last = previous;
        } else {
            //自己的下一个结点的previous指向自己的上一个结点
            next.previous = previous;
            //自己的下一个指针移除
            node.next = null;
        }

        //自己的值移除
        node.value = null;
        size--;
    }

    /**
     * 覆盖指定位置的值
     * @param index 指定位置
     * @param t 新的值
     */
    public void set(int index, T t) {
        this.checkElementIndex(index);
        LinkedNode<T> node = node(index);
        node.value = t;
    }

    LinkedNode<T> node(int index) {
        LinkedNode<T> node;
        if (index < size >> 1) {
            //小于长度的二分之一 从头开始遍历
            node = first;
            for (int i = 0; i < index; i++) {
                //从头结点往后遍历 index-1 次 后 取下一个结点（拿到下标为index的结点）
                node = node.next;
            }
        } else {
            //大于长度的二分之一 从后向前遍历
            node = last;
            for (int i = size - 1; i > index; i--) {
                //从尾结点往前遍历 size-index 次 后 取上一个结点（拿到下标为index的结点）
                node = node.previous;
            }
        }
        return node;
    }

    public T get(int index) {
        this.checkElementIndex(index);
        return node(index).value;
    }

    public int size() {
        return size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

}
