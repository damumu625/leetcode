package com.zym.leetcode;

import java.util.Scanner;

/**
 * Created by damumu on 2017/7/26.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length()+1; i++) {
            char c = i == s.length() ? '*':s.charAt(i);
            if (c == 'A' || c == 'T' || c == 'C' || c == 'G') {
                temp++;
            } else {
                result = Math.max(result, temp);
                temp = 0;
            }
        }
//        if(result == 0&&s.length()!=0&&(s.charAt(0) == 'A' || s.charAt(0) == 'T' || s.charAt(0) == 'C' || s.charAt(0) == 'G')){
//            result = s.length();
//        }
        System.out.println(result);
    }
}
