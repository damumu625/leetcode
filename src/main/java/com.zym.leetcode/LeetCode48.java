package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 判断一个二叉树是否是镜像的
 */
public class LeetCode48 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t2.right = t4;
        System.out.println(isSymmetric(t0));
    }
    public static boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
