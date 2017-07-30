package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/28.
 */
/*
 有一个全部是非负整数的m * n的矩阵，从左上角到右下角早到一条路径，
 使得路径上的和最小，任何时候只能想右或下运动。
 */
public class LeetCode86 {
    public static void main(String[] args) {
        int[][] grid = {{1, 4, 5}, {2, 4, 6}, {3, 4, 5}, {1, 1, 1}};
        System.out.println(minPathSum1(grid));
    }

    //递归，深度优先
    public static int minPathSum(int[][] grid) {
        return minPathSumHelper(0, 0, grid);
    }

    private static int minPathSumHelper(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i == grid.length - 1) {
            return grid[i][j] + minPathSumHelper(i, j + 1, grid);
        }
        if (j == grid[0].length - 1) {
            return grid[i][j] + minPathSumHelper(i + 1, j, grid);
        }
        return grid[i][j] + Math.min(minPathSumHelper(i + 1, j, grid), minPathSumHelper(i, j + 1, grid));
    }

    //动态规划
    public static int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
