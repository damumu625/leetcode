package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 判断两颗二叉树是否相等
 */
public class LeetCode49 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode p1 = new TreeNode(2);
        TreeNode p2 = new TreeNode(3);
        p.left = p1;
        p.right = p2;
        TreeNode q = new TreeNode(1);
        TreeNode q1 = new TreeNode(2);
        TreeNode q2 = new TreeNode(3);
        q.left = q1;
        q.right = q2;
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
