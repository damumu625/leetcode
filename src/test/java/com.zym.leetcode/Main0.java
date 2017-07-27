package com.zym.leetcode;

import java.util.Scanner;

/**
 * Created by damumu on 2017/7/25.
 */
public class Main0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length() - 2;
        while (len >= 0) {
            if (isOddString(s.substring(0, len))) {
                break;
            }
            len -= 2;
        }
        System.out.println(len);
    }

    private static boolean isOddString(String s) {
        if (s.length() % 2 != 0)
            return false;
        char[] arr = s.toCharArray();
        int mid = arr.length / 2;
        int i = 0, j = mid;
        while (i < mid && j < arr.length) {
            if (arr[i++] != arr[j++]) {
                return false;
            }
        }
        if (i == mid && j == arr.length) {
            return true;
        }
        return false;
    }
}
