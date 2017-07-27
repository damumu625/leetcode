package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 一个台阶有n阶高，一次能跳一阶或两阶，一共有多少种跳法；
 */
public class LeetCode79 {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int last0 = 1;
        int last1 = 2;
        int result = 2;
        for (int i = 3; i <= n; i++) {
            result = last0 + last1;
            last0 = last1;
            last1 = result;
        }
        return result;
    }
}
