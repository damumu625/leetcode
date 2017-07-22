package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 二叉排序树的两个节点被错误的交换了
 在不改变树的结构下恢复树，能在常数的额外空间吗
 */
public class LeetCode50 {
    private static TreeNode first = null;
    private static TreeNode second = null;
    private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t2.right = t4;
        recoverTree(t0);
    }

    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
