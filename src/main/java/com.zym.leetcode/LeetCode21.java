/*******************************************************
 * Copyright (C) 2017 iQIYI.COM - All Rights Reserved
 * <p/>
 * This file is part of leetcode project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * <p/>
 * Author(s): zhangyongming_sx <zhangyongming_sx@qiyi.com>
 *******************************************************/
package com.zym.leetcode;

/*
 在棋盘上有X和O，把被X包围的O置为X
 例如：            运行后：
     X  X  X  X          X  X  X  X
     X  O  O  X          X  X  X  X
     X  X  O  X          X  X  X  X
     X  O  X  X          X  O  X  X
 思路：找到四周上的O深度遍历与之相连的O,标示一下
 */

public class LeetCode21 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
//        char[][] board = {{}};
//        char[][] board = {};
        solve(board);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] result = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    changeBoard(m, n, i, j, board, result);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == false && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void changeBoard(int m, int n, int i, int j, char[][] board, boolean[][] result) {
        if (board[i][j] == 'X' || result[i][j] == true) {
            return;
        }
        result[i][j] = true;
        if (i > 0) {
            changeBoard(m, n, i - 1, j, board, result);
        }
        if (j > 0) {
            changeBoard(m, n, i, j - 1, board, result);
        }
        if (i < m - 1) {
            changeBoard(m, n, i + 1, j, board, result);
        }
        if (j < n - 1) {
            changeBoard(m, n, i, j + 1, board, result);
        }
    }
}
