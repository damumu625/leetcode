package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/15.
 */
/*
 返回第k行的杨辉三角，最后只使用O(k)的额外空间
 */
public class LeetCode32 {
    public static void main(String[] args) {
        System.out.println(getRow(6));
    }

    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex);
        result.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                if (result.size() <= j) {
                    result.add(0);
                }
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
