package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 给定s1、s2、s3，查找是否由s1和s2交织形成s3。
 例如s1 ="aabcc",s2 ="dbbca",如果s3="aadbbcbcac",返回true,
                             如果s3="aadbbbaccc",返回false;
 动态规划，table[i][j]表示s1的前i项和s2的前j项能否交织形成s3的前i+j项
 */
public class LeetCode52 {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = true;
                } else if (i == 0) {
                    table[i][j] = table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    table[i][j] = table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    table[i][j] = (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                            || (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return table[s1.length()][s2.length()];
//        if (s3.length() == 0) {
//            return true;
//        }
//        if ((s1.length() == 0 || s3.charAt(0) != s1.charAt(0)) && (s2.length() == 0 || s3.charAt(0) != s2.charAt(0))) {
//            return false;
//        }
//        return (s1.length() != 0 && isInterleave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length())))
//                || (s2.length() != 0 && isInterleave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length())));
    }
}
