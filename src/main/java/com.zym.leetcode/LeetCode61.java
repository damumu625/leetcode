package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/24.
 */
/*
 给定两个顺序数组A和B，把B合并进A，形成一个新的顺序数组
 假设A有足够的空间容纳B，A和B初始化的元素个数为m和n
 */
public class LeetCode61 {
    public static void main(String[] args) {
        int[] A = new int[10];
        A[0] = 2;
        A[1] = 3;
        A[2] = 6;
        A[3] = 8;
        A[4] = 9;
        int[] B = {1, 5, 7};
        merge(A, 5, B, 3);

    }

    public static void merge(int A[], int m, int B[], int n) {
        for (int i = m; i > 0; i--) {
            A[i + n - 1] = A[i - 1];
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i + n] < B[j]) {
                A[i + j] = A[i + n];
                i++;
            } else {
                A[i + j] = B[j];
                j++;
            }
        }
        if (j < n) {
            while (j < n) {
                A[m + j] = B[j];
                j++;
            }
        }
    }
}
