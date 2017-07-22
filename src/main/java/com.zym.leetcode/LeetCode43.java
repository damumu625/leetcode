package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 给定一个树的中序遍历和后序遍历，构造该二叉树
 假设没有重复的值
 */
public class LeetCode43 {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3};
        int[] postorder = {4, 5, 2, 6, 3, 1};
        TreeNode root = buildTree(inorder, postorder);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public static TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il == ir) {
            return null;
        }
        int i = il;
        for (; i < ir; i++) {
            if (inorder[i] == postorder[pr - 1]) {
                break;
            }
        }
        TreeNode head = new TreeNode(inorder[i]);
        head.left = buildTree(inorder, il, i, postorder, pl, pl + i - il);
        head.right = buildTree(inorder, i + 1, ir, postorder, pr - ir + i, pr - 1);
        return head;
    }
}
