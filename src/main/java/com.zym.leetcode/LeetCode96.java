package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 顺时针旋转输出矩阵
 例如矩阵为：{{1, 2, 3},
              {4, 5, 6},
              {7, 8, 9}}
 返回：{1, 2, 3, 6, 9, 8, 7, 4, 5}
 */
public class LeetCode96 {
    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{2, 3}};
        System.out.println(spiralOrder(matrix));
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
            }
            bottom--;
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    result.add(matrix[j][left]);
                }
            }
            left++;
        }
        return result;
    }
}
