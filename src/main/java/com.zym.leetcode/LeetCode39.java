package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/21.
 */
/*
 给定一个二叉树，判断它是否是高度平衡的二叉树
 即任意两个叶子节点的深度之差不会大于1
 */
public class LeetCode39 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(5);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(11);
        TreeNode t4 = new TreeNode(13);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(5);
        TreeNode t9 = new TreeNode(1);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;
        long time1 = System.nanoTime();
        System.out.println(isBalanced(t0));
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);
        System.out.println(isBalanced1(t0));
        long time3 = System.nanoTime();
        System.out.println(time3 - time2);
    }
    public static boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public static int dfsHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfsHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfsHeight(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced1(TreeNode root) {
        return root == null
                || Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1
                && isBalanced1(root.left)
                && isBalanced1(root.right);
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
