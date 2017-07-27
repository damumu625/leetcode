package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 给定一个m×n矩阵，如果一个元素为0，则将整个行和列设置为0
 你能想出一个常数空间的方案吗？
 */
public class LeetCode76 {
    public static void main(String[] args) {
        int[][] matrix = {{0,2,3,4},{5,6,7,0},{1,2,2,3},{3,5,6,4}};
        setZeroes(matrix);
        for (int[] row: matrix) {
            for (int col: row) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        boolean col0 = false;
        int row = matrix.length,col = matrix[0].length;
        for (int i = 0;i<row;i++){
            if (matrix[i][0] == 0){
                col0 = true;
            }
            for (int j = 1; j <col ; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >=0 ; i--) {
            for (int j = col - 1; j >= 1 ; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if (col0){
                matrix[i][0] = 0;
            }
        }
    }
}
