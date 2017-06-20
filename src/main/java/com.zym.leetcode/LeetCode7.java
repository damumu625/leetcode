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

/*
    二叉树的先序遍历，递归小儿科了，使用迭代
 */

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode7 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(6);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t3.right = t4;
        t2.left = t5;
        System.out.print(preorderTraversal(t0));
    }
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.peek();
            result.add(temp.val);
            stack.pop();
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
        return result;
    }
}
