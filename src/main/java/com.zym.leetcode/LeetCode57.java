package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 把链表的m到n处部分翻转 1<=m<=n<=length
 */
public class LeetCode57 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = reverseBetween(l1, 2, 4);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        int temp = m;
        while (--temp > 0) {
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = start.next;
        while (n-- > m) {
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = start.next;
        }
        return newHead.next;
    }
}
