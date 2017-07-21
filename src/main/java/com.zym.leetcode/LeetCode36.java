package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/16.
 */
/*
 给定一个字符串S和一个字符串T，返回T在S中不同的子序列个数
 一个字符串A是另一个字符串B的子序列，表示B通过删除某几个字符串
 等于A,但不改变字符串的顺序，例如"ACE"是"ABCDE"的子序列，而"AEC"
 就不是。
 */
public class LeetCode36 {
    public static void main(String[] args) {
        String S = "rabbbit", T = "rabbit";
        System.out.println(numDistinct(S, T));
    }

    public static int numDistinct(String S, String T) {
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        for (int j = 0; j < S.length() + 1; j++) {
            mem[0][j] = 1;
        }

        for (int i = 0; i < T.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }
        return mem[T.length()][S.length()];
    }
}
