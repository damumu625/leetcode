package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/30.
 */
/*
 输出x的n次方
 */
public class LeetCode100 {
    public static void main(String[] args) {
        System.out.println(pow(-1.00000, 2147483647));
    }

    public static double pow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return pow(x, n + 1) * pow(x, -1);
        }
        if (n < 0) {
            return 1d / pow(x, -n);
        }
        if (n == 0) {
            return 1d;
        }
        if (n == 1) {
            return x;
        }
        double result = 1;
        double temp = 1;
        boolean b = true;
        int m = n;
        int i = 0;
        while (m > 0) {
            m = m >> 1;
            if (temp == 1 && b) {
                temp = x;
                b = false;
            } else {
                temp = temp * temp;
            }
            if ((n & (1 << i)) != 0) {
                result *= temp;
            }
            i++;
        }
        return result;
    }
}
