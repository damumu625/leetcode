package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/28.
 */
/*
 从一个m * n的矩阵的左上角走到右下角有多少种不同的走法
 每次都能向下或向右走一步
 */
public class LeetCode88 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(1,2));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
