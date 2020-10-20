package com.test.list;

import com.test.model.ListNode;

/**
 * @author 崔航
 * @date 2020/7/7 11:12
 * 面试题 02.03. 删除中间节点
 */
public class DeleteMiddleNode {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        solutionOne(listNode3);
    }

    private static void solutionOne(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
