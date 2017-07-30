package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 给定一个链表，将链表旋转到右边的k个位置，其中k是非负的。
 例如：给定1->2->3->4->5->NULL  k =2,
       返回4->5->1->2->3->NULL.
 */
public class LeetCode89 {
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
        ListNode listNode = rotateRight(l1, 7);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        int len = 0;
        while (first != null) {
            first = first.next;
            len++;
        }
        first = head;
        for (int i = 0; i < n % len; i++) {
            first = first.next;
        }
        if (first == null){
            return head;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        ListNode newHead = second.next;
        second.next = null;
        return newHead;
    }
}
