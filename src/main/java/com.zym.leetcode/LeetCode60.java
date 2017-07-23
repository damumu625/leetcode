package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 打印n位的格雷码对应的二进制数
 格雷码指每次只改变一位上的值
 例如
 */
public class LeetCode60 {
    public static void main(String[] args) {
        System.out.println(grayCode(0));
    }
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1 << (i - 1); j < 1 << i; j++) {
                result.add(result.get((1 << i) - j - 1) + (1 << (i - 1)));
            }
        }
        return result;
    }
}
