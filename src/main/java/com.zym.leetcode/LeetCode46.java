package com.zym.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 给定一个二叉树，返回从顶部到底部的节点值，
 第一层从左到右，第二层从右向左...
 例如给定 3     返回[
         / \          [3]
        9  20         [20, 9]
      /  \            [15, 7]
     15   7         ]
 */
public class LeetCode46 {
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
        System.out.println(zigzagLevelOrder(t0));
    }
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        boolean leftToRight = true;
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollLast();
                if (leftToRight) {
                    list.add(temp.val);
                } else {
                    list.add(0, temp.val);
                }
                if (temp.left != null) {
                    queue.push(temp.left);
                }
                if (temp.right != null) {
                    queue.push(temp.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(list);
        }
        return result;
    }
}
