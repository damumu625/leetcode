package com.zym.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 判断一个数是否是二叉排序树
 */
public class LeetCode51 {
    private static int current = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(5);
        t0.left = t1;
        t0.right = t2;
        t2.left = t3;
        t2.right = t4;
        System.out.println(isValidBST(t0));
    }

    public static boolean isValidBST(TreeNode root) {
//        return root == null || !(root.left != null && root.left.val >= root.val) && !(root.right != null && root.right.val <= root.val) && isValidBST(root.left) && isValidBST(root.right);
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= current) {
            return false;
        } else {
            current = root.val;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
