package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 给定一个整数n，返回一个用1到n*n填充的n x n的矩阵，从左上角顺时针填充，
 例如n = 3,返回{{1, 2, 3}，{8, 9, 4}，{7, 6, 5}}
 */
public class LeetCode91 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(2);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                matrix[j][right] = num++;
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
            }
            bottom--;
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    matrix[j][left] = num++;
                }
            }
            left++;
        }
        return matrix;
    }
}
