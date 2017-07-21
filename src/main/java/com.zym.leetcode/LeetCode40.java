package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/21.
 */
/*
 给定一个单向升序的链表，转化成BST(二叉排序树)
 */
public class LeetCode40 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        TreeNode head = sortedListToBST(l0);

    }
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return toBST(head, null);
    }

    public static TreeNode toBST(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode slow = start, fast = start;
        while (fast != end && fast.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode head = new TreeNode(slow.val);
        head.left = toBST(start, slow);
        head.right = toBST(slow.next, end);
        return head;
    }
}
