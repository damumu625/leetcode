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
    树的最小深度
 */

public class LeetCode1 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(0);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t3.right = t4;
        t2.left = t5;
        System.out.print(run(t1));
    }

    private static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = run(root.left);
        int right = run(root.right);
        if (root.left == null || root.right == null) {
            return left + right + 1;
        }
        return left > right ? right + 1 : left + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
