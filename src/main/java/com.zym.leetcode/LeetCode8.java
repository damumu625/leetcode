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
    单项链表0>1>...>n-1>n
    转换成0>n>1>n-1>2>n-2>...
 */

public class LeetCode8 {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        reorderList(listNode0);
        ListNode listNode = listNode0;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode temp1, temp2, temp3;
        temp1 = temp3 = head;
        temp2 = head.next;
        while (temp3.next.next != null) {
            temp3 = temp3.next;
        }
        temp1.next = temp3.next;
        temp3.next = null;
        temp1.next.next = temp2;
        reorderList(temp2);
    }
}
