package com.zym.leetcode;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by damumu on 2017/7/26.
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (!Objects.equals(s, "")) {
            int num = Integer.valueOf(s);
            int i = num;
            int sum = 0;
            while (i-- > 2) {
                int n = 0;
                while (num > Math.pow(i, n)) {
                    n++;
                }
                int num1 = num;
                while (n-- > 0) {
                    sum += num1 / (int) Math.pow(i, n);
                    num1 = num1 % (int) Math.pow(i, n);
                }
            }
            int s1 = sum;
            int s2 = num - 2;
            while (s1 % s2 != 0) {
                int temp = s1 % s2;
                s2 = temp;
                s1 = s2;
            }
            sum = sum/s2;
            num = (num - 2)/s2;
            System.out.println(sum + "/" + num );
            s = scanner.nextLine();
        }
    }
}
