package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/20.
 */

/*
 给定一个二叉树和一个和，找到从根节点到叶子节点的路径和
 刚好等于给定的和的所有路径
 */
public class LeetCode37 {
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
        System.out.println(pathSum(t0, 22));
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);
        System.out.println(pathSum1(t0, 22));
        long time3 = System.nanoTime();
        System.out.println(time3 - time2);
    }

    public static void pathSum1(TreeNode root, int sum, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        temp.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        } else {
            pathSum1(root.left, sum - root.val, temp, result);
            pathSum1(root.right, sum - root.val, temp, result);
        }
        temp.remove(temp.size() - 1);
    }

    public static ArrayList<ArrayList<Integer>> pathSum1(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        pathSum1(root, sum, temp, result);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>());
        }
        ArrayList<ArrayList<Integer>> leftList = pathSum(root.left, sum - root.val);

        ArrayList<ArrayList<Integer>> rightList = pathSum(root.right, sum - root.val);
        if (leftList.size() != 0 || rightList.size() != 0) {
            result.addAll(leftList);
            result.addAll(rightList);
        }
        if (result.size() > 0) {
            for (ArrayList<Integer> list : result) {
                list.add(0, root.val);
            }
        }
        return result;
    }
}
