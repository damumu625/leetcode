package com.zym.leetcode;

import java.util.Scanner;

/**
 * Created by damumu on 2017/7/25.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        if (n == 1) {
//            System.out.println(1);
//        } else {
//            System.out.println((num(n, n - 1, 0) + num(n, n - 1, 1)) % 1000000007);
        System.out.println((num(n, n, 0) % 1000000007));
//        }
    }

    private static int num(int n, int i, int temp) {
        if (i == 1) {
            String s = "1Y";
            for (int j = n - 2; j >= 0; j--) {
                s += " ";
                s += (n - j);
                int a = temp & (1 << j);
                if (a != 0) {
                    s += "Y";
                } else {
                    s += "N";
                }
            }
            System.out.println(s);
            return 1;
        }
        int x = 0;
        boolean b = true;
        for (int j = n; j > i; j--) {
            int a = temp & (1 << x++);
            if (a != 0 && j % i == 0) {
                b = false;
                break;
            }
        }
        return num(n, i - 1, temp + (1 << (n - i))) % 1000000007 + (b ? num(n, i - 1, temp) % 1000000007 : 0);
    }
}
