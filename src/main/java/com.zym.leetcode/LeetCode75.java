package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 在m×n矩阵中搜索一个值。这个矩阵具有以下属性：
 每行中的整数从左到右排序。
 每一行的第一个整数大于前一行的最后一个整数。
 */
public class LeetCode75 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 8;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
