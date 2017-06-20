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
    使用插入排序对链表排序
 */

public class LeetCode5 {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(7);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        insertionSortList(listNode0);
        ListNode listNode = listNode0;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result, temp1, temp2;
        result = temp1 = head;
        head = head.next;
        temp1.next = null;
        while (head != null) {
            temp1 = result;
            temp2 = head;
            if (result.val > head.val) {
                head = head.next;
                temp2.next = result;
                result = temp2;
                continue;
            }
            while (temp1.next != null) {
                if (head.val > temp1.next.val) {
                    temp1 = temp1.next;
                } else {
                    break;
                }
            }
            head = head.next;
            temp2.next = null;
            if (temp1.next == null) {
                temp1.next = temp2;
            } else {
                temp2.next = temp1.next;
                temp1.next = temp2;
            }
        }
        return result;
    }
}
