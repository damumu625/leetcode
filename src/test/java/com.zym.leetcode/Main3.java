package com.zym.leetcode;

import java.util.Scanner;

/**
 * Created by damumu on 2017/7/26.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]){
                chars[i] = '*';
                result++;
            }
        }
        System.out.println(result);
    }
}
