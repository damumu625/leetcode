package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 给定n,返回所有可能结构的二叉排序树的个数，包含值1...n
 */
public class LeetCode54 {
    public static void main(String[] args) {
        System.out.println(numTrees1(2));
    }
    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] nums = new int[n + 1];
        return numTrees(nums, n);

    }

    public static int numTrees(int[] nums, int n) {
        if (nums[n] != 0) {
            return nums[n];
        }
        if (n == 0 || n == 1) {
            nums[n] = 1;
            return 1;
        }

        for (int i = 0; i < n; i++) {
            nums[n] += numTrees(nums, i) * numTrees(nums, n - i - 1);
        }
        return nums[n];
    }
    public static int numTrees1(int n){
        int [] nums = new int[n+1];
        nums[0] = nums[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                nums[i] += nums[j-1] * nums[i-j];
            }
        }

        return nums[n];
    }
}
