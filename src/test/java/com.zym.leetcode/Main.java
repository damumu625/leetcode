/*******************************************************
 * Copyright (C) 2017 iQIYI.COM - All Rights Reserved
 * <p/>
 * This file is part of leetcode project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * <p/>
 * Author(s): zhangyongming_sx <zhangyongming_sx@qiyi.com>
 *******************************************************/

package com.zym.leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int unknown;
        boolean error;
        String str;
        while (true) {
            str = sc.nextLine();
            if(str.equals("")){
                break;
            }
            int n = Integer.valueOf(str);
            unknown = 0;
            error = false;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                str = sc.nextLine();
                if(error){
                    continue;
                }
                if(str.equals("?")){
                    unknown ++;
                    continue;
                }
                String[] strings = str.split(" ");
                if(strings[0].equals("I")){
                    list.add(strings[1]);
                }
                if(strings[0].equals("O")){
                    if(list.contains(strings[1])){
                        list.remove(strings[1]);
                    }else {
                        unknown --;
                        if(unknown < 0){
                            System.out.println(i+1);
                            error = true;
                        }
                    }
                }
            }
            if(!error){
                System.out.println(-1);
            }
        }
    }
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int score = 0, rank = n, temp;
        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            if (i == 0) {
                score = temp;
            }
            if (score < temp) {
                rank--;
            }
        }
        System.out.print(roundNum(rank));
    }

    private static int roundNum(int rank) {
        int roundNum = 0;
        while (rank > 0) {
            roundNum++;
            rank = rank >> 1;
        }
        roundNum--;

        return roundNum;
    }*/
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            if (i >= n - 1) {
                int diff = difference(a, b, i);
                res = diff < res ? diff : res;
            }
        }
        System.out.print(res);
    }

    private static int difference(int[] a, int[] b, int i) {
        int sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] - b[i - a.length + 1 + j]) * (a[j] - b[i - a.length + 1 + j]);
        }
        return sum;
    }*/
}
