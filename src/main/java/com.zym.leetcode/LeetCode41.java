package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 给定一个升序的数组，转化成BST(二叉排序树)
 */
public class LeetCode41 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        TreeNode head = sortedArrayToBST(num);

    }

    public static TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length);
    }

    public static TreeNode toBST(int[] num, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode head = new TreeNode(num[mid]);
        head.left = toBST(num, start, mid);
        head.right = toBST(num, mid + 1, end);
        return head;
    }
}
