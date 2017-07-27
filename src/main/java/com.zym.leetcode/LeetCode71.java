package com.zym.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by damumu on 2017/7/26.
 */
/*
 给出一个互异的整数数组，返回所有可能的子集
 */
public class LeetCode71 {
    public static void main(String[] args) {
        int[] S = {1,2,3};
        System.out.println(subsets(S));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int value : S) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> instance = new ArrayList<>(result.get(j));
                instance.add(value);
                result.add(new ArrayList<>(instance));
            }
        }
        return result;
    }
}
