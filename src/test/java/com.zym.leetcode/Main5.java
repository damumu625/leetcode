package com.zym.leetcode;

import java.util.Scanner;

/**
 * Created by damumu on 2017/7/26.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                boolean b = true;
                for (int k = j + 1; k < i; k++) {
                    if (array[k] > array[i] || array[k] > array[j]) {
                        b = false;
                        break;
                    }
                }
                if (!b) {
                    b = true;
                    for (int k = i + 1; k < j + n; k++) {
                        if (array[k % n] > array[i] || array[k % n] > array[j]) {
                            b = false;
                            break;
                        }
                    }
                }
                if (b) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
