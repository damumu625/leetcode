package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/28.
 */
/*
 用一个数组表示一个大整数，每个位存放一位，把这个大整数加1并返回。
 */
public class LeetCode82 {
    public static void main(String[] args) {
        int[] digits = {9,9,9,8};
        int[] result = plusOne(digits);
        for (int n: result) {
            System.out.println(n);
        }
    }
    public static int[] plusOne(int[] digits) {
        int num = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += num;
            num = digits[i] / 10;
            if (num == 0) {
                break;
            }
            digits[i] %= 10;
        }
        if (num > 0) {
            int[] copy = new int[digits.length+1];
            System.arraycopy(digits, 0, copy, 1,
                    digits.length);
            copy[0] = 1;
            return copy;
        }
        return digits;
    }
}
