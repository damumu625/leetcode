package com.zym.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 给定可能含重复项的整数集合，返回所有满足条件子集
 1，子集必须是递增的  2，不能有重复子集
 */
public class LeetCode58 {
    public static void main(String[] args) {
        int[] num = {0};
        System.out.println(subsetsWithDup(num));
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < num.length; ) {
            int count = 0;
            while (count + i < num.length && num[count + i] == num[i]) {
                count++;
            }
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> instance = new ArrayList<>(result.get(j));
                for (int k = 0; k < count; k++) {
                    instance.add(num[i]);
                    result.add(new ArrayList<>(instance));
                }
            }
            i += count;
        }
        return result;
    }
}
