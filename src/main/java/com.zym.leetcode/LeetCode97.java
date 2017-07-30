package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/30.
 */
/*
 给定一个整形数组，返回相加和最大的连续子数组的和
 例如：给定数列[−2,1,−3,4,−1,2,1,−5,4],
 子数组[4,−1,2,1]拥有最大的和6.
 */
public class LeetCode97 {
    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(A));
    }

    public static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + Math.max(dp[i - 1], 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
