package com.test.list;

import com.test.model.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 崔航
 * @date 2020/10/30 11:17
 * 2. 两数相加
 */
@Slf4j
public class AddTwoNumberByLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = solutionOne(l1, l2);
        log.info("{}", listNode);
    }

    private static ListNode solutionOne(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode flag = listNode;
        //进位为0
        int carry = 0;
        while (null != l1 || null != l2) {
            int x = null == l1 ? 0 : l1.val;
            int y = null == l2 ? 0 : l2.val;
            int sum = x + y + carry;
            if (sum > 9) {
                //如果大于9需要进1位 （两个一位数相加不存在大于18的情况）
                carry = 1;
                sum = sum - 10;
            } else {
                //进位归零
                carry = 0;
            }
            //高位放后面 第一次时个位结果放在0后面
            flag.next = new ListNode(sum);
            flag = flag.next;
            //指针后移获取高位
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //如果最高位计算完毕进位为1，在最后一位添加结点1
        if (carry == 1) {
            flag.next = new ListNode(carry);
        }
        //返回0后面的链表
        return listNode.next;
    }
}
