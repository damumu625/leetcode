package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/25.
 */
/*
 给定一个排序数组，删除多余的元素，保证同样的数字之多出现两次
 例如给定A={1,1,1,2,2,3}，返回5，且A={1,1,2,2,3}
 */
public class LeetCode69 {
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(A));
    }

    public static int removeDuplicates(int[] A) {
        int i = 0;
        for (int n : A)
            if (i < 2 || n > A[i-2])
                A[i++] = n;
        return i;
    }
}
