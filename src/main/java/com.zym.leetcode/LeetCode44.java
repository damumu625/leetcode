package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 给定一个树的前序遍历和中序遍历，构造该二叉树
 假设没有重复的值
 */
public class LeetCode44 {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 6, 3};
        TreeNode root = buildTree(preorder, inorder);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder.length, inorder, 0, inorder.length);
    }

    public static TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl == pr) {
            return null;
        }
        int i = il;
        for (; i < ir; i++) {
            if (inorder[i] == preorder[pl]) {
                break;
            }
        }
        TreeNode head = new TreeNode(inorder[i]);
        head.left = buildTree(preorder, pl + 1, pl + 1 + i - il, inorder, il, i);
        head.right = buildTree(preorder, pr - ir + i + 1, pr, inorder, i + 1, ir);
        return head;
    }
}
