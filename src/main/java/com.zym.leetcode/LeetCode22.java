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

import java.util.ArrayList;
import java.util.List;

/*
 给定一个二叉树，每个节点的值为0-9，根到叶子节点构成一个数，
 求所有数的和。例：1    的和是12+13=25。
                 /   \
                2     3
 我一直考虑的是从下往上，深度返回不出来，只能用字符串
 发现从上往下更好
 */
public class LeetCode22 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t3.right = t4;
        t2.left = t5;
        System.out.print(sumNumbers2(t0));
    }

    public static int sumNumbers1(TreeNode root) {
        List<String> strings = str(root);
        int result = 0;
        for (String str : strings) {
            result += Integer.valueOf(str);
        }
        return result;
    }

    public static List<String> str(TreeNode root) {
        List<String> result = null;
        if (root.left == null && root.right == null) {
            result = new ArrayList<>();
            result.add(String.valueOf(root.val));
            return result;
        }
        if (root.left != null) {
            result = str(root.left);
        }
        if (root.right != null) {
            if (result != null) {
                result.addAll(str(root.right));
            } else {
                result = str(root.right);
            }
        }
        List<String> result1 = new ArrayList<>();
        for (String str : result) {
            result1.add(root.val + str);
        }
        return result1;
    }

    public static int sumNumbers2(TreeNode root) {
        return sum(root, 0);
    }

    public static int sum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sum(root.left, sum) + sum(root.right, sum);
    }
}
