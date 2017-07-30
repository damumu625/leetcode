package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/30.
 */
/*
 n皇后的问题是在n*n的方格中，放置n个皇后，保证n个皇后互相不能攻击
 （皇后能攻击的范围是相同横线，竖线，和正反斜线上的点）
 给定n,返回所有位置情况，用字符串数组表示一种位置情况，一个字符串表示一行
 有皇后的位置是'Q',其余位置用'.'表示。
 */
public class LeetCode99 {
    public static void main(String[] args) {
        ArrayList<String[]> result = solveNQueens(8);
        for (String[] strings : result) {
            System.out.println("\n******************");
            for (String s : strings) {
                System.out.println(s);
            }
            System.out.println("******************\n");
        }
        System.out.println(result.size());
    }

    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<>();
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        dfs(chars,0,result);
        return result;
    }

    public static void dfs(char[][] chars, int currentCol, ArrayList<String[]> result) {
        if (currentCol == chars.length) {
            String[] strings = new String[currentCol];
            for (int i = 0; i < currentCol; i++) {
                strings[i] = String.valueOf(chars[i]);
            }
            result.add(strings);
        }
        for (int i = 0; i < chars.length; i++) {
            if (check(chars, i, currentCol)) {
                chars[i][currentCol] = 'Q';
                dfs(chars, currentCol + 1, result);
                chars[i][currentCol] = '.';
            }
        }
    }

    private static boolean check(char[][] chars, int raw, int col) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < col; j++) {
                if (chars[i][j] == 'Q' && (raw == i || raw + col == i + j || raw + j == col + i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
