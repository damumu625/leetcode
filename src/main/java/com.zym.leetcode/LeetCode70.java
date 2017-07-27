package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/25.
 */
/*
 给定一个二维的字符数组和一个单词，是否存在一条线路
 ，其中的字符可以拼成该单词。
 */
public class LeetCode70 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existHelper(board, i, j, w, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean existHelper(char[][] board, int x, int y, char[] word, int n) {
        if (n == word.length) {
            return true;
        }
        if (x < 0 || y < 0 || x == board.length || y == board[x].length) {
            return false;
        }
        if (board[x][y] != word[n]) {
            return false;
        }
        char temp = board[x][y];
        board[x][y] = '*';
        boolean exit = existHelper(board, x, y + 1, word, n + 1)
                || existHelper(board, x, y - 1, word, n + 1)
                || existHelper(board, x + 1, y, word, n + 1)
                || existHelper(board, x - 1, y, word, n + 1);
        board[x][y] = temp;
        return exit;
    }
}
