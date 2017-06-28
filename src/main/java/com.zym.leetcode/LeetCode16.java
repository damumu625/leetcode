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

/*
 n个孩子站成一排，每个人有相应的分数，给孩子发糖果，保证相邻的两个孩子
 中得分高的获得更高的糖果，每个孩子至少一个糖果
 */

import java.util.Arrays;

public class LeetCode16 {
    public static void main(String[] args) {
        int[] ratings = {3, 2, 1, 2, 3, 4, 1, 2, 3};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int candy = 0;
        int length = ratings.length;
        if(length<=1){
            return length;
        }
        int[] nums = new int[length];
        Arrays.fill(nums, 1);
        for (int i = 0; i < length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                nums[i - 1] = Math.max(nums[i - 1], nums[i] + 1);
            }
        }
        for (int i = 0; i < length; i++) {
            candy += nums[i];
        }
        return candy;
    }
}
