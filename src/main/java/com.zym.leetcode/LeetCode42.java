package com.zym.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by damumu on 2017/7/22.
 */
/*
 给定一个二叉树，返回从底部到顶部，从左到右的节点值
 例如给定 3     返回[
         / \          [15, 7]
        9  20         [9, 20]
      /  \            [3]
     15   7         ]
 */
public class LeetCode42 {
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
        System.out.println(levelOrderBottom(t0));
    }

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.pollLast();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.push(temp.left);
                }
                if (temp.right != null) {
                    queue.push(temp.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }
}
