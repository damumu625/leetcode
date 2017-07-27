package com.zym.leetcode;

import java.util.Scanner;

/**
 * Created by damumu on 2017/7/25.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        boolean[] b = new boolean[26];
        if (s.length()==0){
            System.out.println(0);
        }
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            b[temp] = !b[temp];
        }
        int result = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                result++;
            }
        }
        System.out.println(Math.max(result, 1));
    }
}
