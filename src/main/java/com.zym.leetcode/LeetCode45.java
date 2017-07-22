package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 求一个二叉树的最大深度
 */
public class LeetCode45 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        System.out.println(maxDepth(t0));
    }
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
