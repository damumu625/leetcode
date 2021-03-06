package com.zym.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by damumu on 2017/7/15.
 */

/*
 找出二叉树每个节点的右节点，假设是一个完全二叉树
 只能使用恒定的额外空间
 */
public class LeetCode35 {
    public static void main(String[] args) {
        TreeLinkNode t0 = new TreeLinkNode(0);
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        connect(t0);
    }

    public static void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode temp1 = queue.poll();
            TreeLinkNode temp2 = queue.peek();
            temp1.next = temp2;
            if (temp1.left != null) {
                queue.add(temp1.left);
                queue.add(temp1.right);
            }
        }
        while (root != null) {
            root.next = null;
            root = root.right;
        }
    }
}
