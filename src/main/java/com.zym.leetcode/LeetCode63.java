package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/24.
 */
/*
 给定一个链表和一个值x，将它划分为所有小于x的节点出现在大于或等于x的节点之前。
 您应该保留两个分区中每个节点的原始相对顺序。
 例如,
 1 - > 4 > 3 > 2 > 5 > 2 and x = 3，
 返回1 - > 2 > 2 > 4 > 3 > 5。
 */
public class LeetCode63 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = partition(l1,3);

    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode next = head.next;
        ListNode small = newHead;
        while (head.next != null) {
            if (head.val < x){
                head.next = next.next;
                next.next = small.next;
                small.next = next;
                small = small.next;
            }
            head = head.next;
            next = head.next;
        }
        return newHead.next;
    }
}
