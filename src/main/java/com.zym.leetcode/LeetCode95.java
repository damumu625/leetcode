package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 给定一个非负数组，表示从当前索引最多能跳几步，
 先从第一个索引出发，能否跳到最后一个索引。
 例如 A = [2, 3, 1, 1, 4] 返回true
      A = [3, 2, 1, 0, 4] 返回false。
 */
public class LeetCode95 {
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 0, 4};
        System.out.println(canJump(A));
    }

    public static boolean canJump(int[] A) {
        int n = A.length;
        boolean[] b = new boolean[n];
        b[0] = true;
        for (int i = 0; i < n; i++) {
            if (!b[i] || b[n - 1]) {
                break;
            }
            for (int j = 1; j <= A[i] && i + j < n; j++) {
                b[i + j] = true;
            }
        }
        return b[n - 1];
    }
}
