package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/30.
 */
/*
 n皇后的问题的所有情况的个数
 */
public class LeetCode98 {
    private static int result = 0;

    public static void main(String[] args) {
        System.out.println(totalNQueens(2));
    }

    public static int totalNQueens(int n) {
        boolean[][] b = new boolean[n][n];
        dfs(b, 0);
        return result;
    }

    private static void dfs(boolean[][] b, int currentCol) {
        if (currentCol == b.length) {
            result++;
        }
        for (int i = 0; i < b.length; i++) {
            if (check(b, i, currentCol)) {
                b[i][currentCol] = true;
                dfs(b, currentCol + 1);
                b[i][currentCol] = false;
            }
        }
    }

    private static boolean check(boolean[][] b, int raw, int col) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < col; j++) {
                if (b[i][j] && (raw == i || raw + col == i + j || raw + j == col + i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
