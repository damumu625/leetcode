/*******************************************************
 * Copyright (C) 2017 iQIYI.COM - All Rights Reserved
 * <p/>
 * This file is part of leetcode project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * <p/>
 * Author(s): zhangyongming_sx <zhangyongming_sx@qiyi.com>
 *******************************************************/
package com.zym.leetcode;

/*
 给定一个二叉树，返回最大的路径和，路径可以从任意根节点到更一个根节点
 例如:     1       返回1+2+3=6.
         /   \
        2     3
  左路径的最大值加上右路径的最大值加上当前节点的值，不断更新最大值
 */

public class LeetCode27 {
    private static int maxPathSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(-3);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
//        t0.left = t1;
//        t0.right = t2;
//        t1.left = t3;
//        t3.right = t4;
//        t2.left = t5;
        System.out.println(maxPathSum(t0));
    }

    public static int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPathSum;
    }

    public static int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        int sum = left + right + root.val;
        maxPathSum = Math.max(maxPathSum, sum);
        return Math.max(left + root.val, right + root.val);
    }
}
