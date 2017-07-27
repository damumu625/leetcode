package com.zym.leetcode;

import java.util.Stack;

/**
 * Created by damumu on 2017/7/25.
 */
/*
 给定n个非负整数表示直方图的条形高度，每个条的宽度为1，找到直方图中最大矩形的面积。
 */
public class LeetCode65 {
    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(height));
    }

    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                int temp = height[tp] * (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, temp);
                i--;
            }
        }
        return maxArea;
    }
}
