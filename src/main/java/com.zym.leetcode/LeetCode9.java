/*******************************************************
 * Copyright (C) 2017 iQIYI.COM - All Rights Reserved
 * <p/>
 * This file is part of leetcode project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * <p/>
 * Author(s): zhangyongming_sx <zhangyongming_sx@qiyi.com>
 *******************************************************/
package com.zym.leetcode;

/*
    查找链表循环开始的节点，如果没有，则返回null
 */

public class LeetCode9 {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(7);
        ListNode listNode7 = new ListNode(8);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode3;
        System.out.println(detectCycle(listNode0).val);

    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode step1, step2;
        step1 = step2 = head;
        while (step2.next != null && step2.next.next != null) {
            step1 = step1.next;
            step2 = step2.next.next;
            if (step1.val == step2.val) {
                while (head.val != step1.val) {
                    head = head.next;
                    step1 = step1.next;
                }
                return head;
            }
        }
        return null;
    }
}
