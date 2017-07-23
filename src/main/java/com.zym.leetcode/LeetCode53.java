package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 给定n,生成所有可能结构的二叉排序树，包含值1...n
 */
public class LeetCode53 {
    public static void main(String[] args) {
        ArrayList<TreeNode> result = generateTrees(3);

    }
    public static ArrayList<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    public static ArrayList<TreeNode> generateTreesHelper(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftList = generateTreesHelper(start, i - 1);
            ArrayList<TreeNode> rightList = generateTreesHelper(i + 1, end);
            for (TreeNode leftNode:leftList){
                for (TreeNode rightNode:rightList){
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
