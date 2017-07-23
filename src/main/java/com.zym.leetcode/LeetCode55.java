package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 返回一个二叉树的中序遍历
 */
public class LeetCode55 {
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
        System.out.println(inorderTraversal(t0));
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderTraversalHelper(result, root);
        return result;
    }

    private static void inorderTraversalHelper(ArrayList<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(result, root.left);
        result.add(root.val);
        inorderTraversalHelper(result, root.right);
    }
}
