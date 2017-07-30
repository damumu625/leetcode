package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/28.
 */
/*
 合并两个已排序的链表，为一个新的顺序链表
 */
public class LeetCode85 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        l0.next = l1;l1.next = l2;
        l3.next = l4;l4.next = l5;
        ListNode listNode = mergeTwoLists(l0, l3);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
