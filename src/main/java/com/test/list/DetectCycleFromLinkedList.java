package com.test.list;

import com.test.model.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/10/10 14:47
 * 142. 环形链表 II
 * 返回链表中入环结点
 *
 * 快慢指针：
 * 慢指针一次走一步 快指针一次走两步 找到快慢指针相遇的结点
 * 此时从头结点再出发一个指针，与相遇结点作为起点的指针一同出发，相遇点为入环点
 * 设 环外长度为a，入环点走到相遇点长度b，相遇点走到入环长度c
 * 则相遇时慢指针走的距离为 a+b 快指针走的距离是 a+b+n(b+c)
 * 因为快指针走过的长度是慢指针的 2 倍 所以 2(a+b+m(b+c)) = a+b+n(b+c)
 * 整理得 a+b=x个环的长度 所以a和c的距离是相同的
 */
@Slf4j
public class DetectCycleFromLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        ListNode listNode = solutionOne(node1);
        log.info("{}", listNode);
    }

    public static ListNode solutionOne(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            //快慢指针，快指针每次走两步，慢指针每次走一步
            fast = fast.next.next;
            slow = slow.next;
            //先判断是否有环，
            if (slow == fast) {
                //确定有环之后才能找环的入口
                while (head != slow) {
                    //两相遇指针，一个从头结点开始，
                    //一个从相遇点开始每次走一步，直到
                    //再次相遇为止
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
