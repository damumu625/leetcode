package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/15.
 */
/*
 返回n行杨辉三角
 */
public class LeetCode33 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int sum = 1;
                if (j != 0 && j != i) {
                    sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }
        return result;
    }
}
