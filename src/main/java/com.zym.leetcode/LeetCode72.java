package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/26.
 */
/*
 给定两个整数n和k, 返回所有包含k个在1到n中的数的数组
 例如： n = 4 ， k = 2, 结果是:[
                                 [2,4],
                                 [3,4],
                                 [2,3],
                                 [1,2],
                                 [1,3],
                                 [1,4],
                                        ]
 */
public class LeetCode72 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        combineHelper(result, temp, 1, n, k);
        return result;
    }

    public static void combineHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb,
                                     int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(comb));
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combineHelper(result, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
