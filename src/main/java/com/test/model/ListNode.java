package com.test.model;

import lombok.Data;

/**
 * @author 崔航
 * @date 2020/7/7 11:12
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (null == next ? "" : next.val) +
                '}';
    }
}
