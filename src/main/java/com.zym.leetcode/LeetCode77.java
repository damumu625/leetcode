package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 给定两个单词word1和word2，找到从word1需要转换到word2的最小步数。（每个操作数为1步。）
 你有以下3个所允许的操作：
  a）插入字符
  b）删除字符
  c）替换字符
 */
public class LeetCode77 {
    public static void main(String[] args) {
        System.out.println(minDistance("low", "lew"));
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
