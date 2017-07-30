package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/28.
 */
/*
 给定连=两个二进制的字符串，返回他们它们的和（也是二进制）
 例如 a = "11", b = "1", 返回 "100"
 */
public class LeetCode84 {
    public static void main(String[] args) {
        System.out.println(addBinary("11111", "101"));
    }

    public static String addBinary(String a, String b) {
        int num = 0;
        String result = "";
        for (int i = 0; i < a.length() || i < b.length(); i++) {
            int aNum = (i < a.length() ? a.charAt(a.length() - i - 1) : '0') - '0';
            int bNum = (i < b.length() ? b.charAt(b.length() - i - 1) : '0') - '0';
            int temp = aNum + bNum + num;
            num = temp / 2;
            result = temp % 2 + result;
        }
        if (num == 1) {
            result = 1 + result;
        }
        return result;
    }
}
