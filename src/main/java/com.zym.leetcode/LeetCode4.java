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
    在时间复杂度O(nlgn)内对链表排序，归并排序，利用快慢指针求中间节点
 */
public class LeetCode4 {
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
        sortList(listNode0);
        ListNode listNode = listNode0;
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode middleNext = middle.next;
        middle.next = null;

        return merger(sortList(head), sortList(middleNext));
    }

    private static ListNode merger(ListNode left, ListNode right) {
        if (right == null) {
            return left;
        }
        ListNode result, temp;
        if (left.val < right.val) {
            result = temp = left;
            left = left.next;
        } else {
            result = temp = right;
            right = right.next;
        }
        while (left != null || right != null) {
            if (left == null) {
                temp.next = right;
                return result;
            } else if (right == null) {
                temp.next = left;
                return result;
            } else if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        return result;
    }

    private static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
