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
    给定一个整数数组，除了其中一个元素之外，每个元素都出现两次。
    找到这个元素。在O(n)复杂度完成，不使用额外空间
 */

public class LeetCode15 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 1, 4, 3, 2};
        System.out.println(singleNumber(A));
    }

    public static int singleNumber(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }
}
