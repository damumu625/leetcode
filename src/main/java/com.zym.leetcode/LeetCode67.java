package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/25.
 */
/*
 给定一个已排序的链表，删除具有重复数字的节点，保证一个数字只出现一次。
 例如：给定1->2->3->3->4->4->5, 返回1->2->3->4->5.
       给定1->1->1->2->3, 返回1->2->3.
 */
public class LeetCode67 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        ListNode listNode = deleteDuplicates(l0);

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode start = head;
        ListNode then = start.next;
        while (then != null) {
            if (start.val != then.val) {
                start.next = then;
                start = then;
            }
            then = then.next;
        }
        start.next = then;
        return head;
    }
}
