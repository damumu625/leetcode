package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 计算并返回x的平方根
 */
public class LeetCode80 {
    public static void main(String[] args) {
        System.out.println(sqrt(2147395599));
    }
    public static int sqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
