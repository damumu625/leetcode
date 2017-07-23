package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 给定一个映射'A'->1...'Z'->26;给定一个数字字符串"12",
 对应字符"AB"(1 2)和L(12);,返回所有可能的情况的个数。
 */
public class LeetCode59 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') {
                continue;
            } else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0];
    }
}
