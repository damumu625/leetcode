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
 给定一个未排序的整数数组，返回最长的连续序列的长度，
 例如[4,100,2,101,1,200,3],最长的连续序列是[1,2,3,4],所以返回4
 算法的复杂度要求O(n)；
 map保存每个点当前所在区间的长度，如果不在区间边界，则无所谓。
 当有新点n加入时，如果是新出现的点查看n-1和n+1的区间，把n加入，
 更新n-1所在区间的左边界和n+1所在区间的右边界为新区间的长度。
 */

import java.util.HashMap;
import java.util.Map;

public class LeetCode23 {
    public static void main(String[] args) {
        int[] num = {4, 100, 2, 101, 1, 200, 3};
        System.out.println(longestConsecutive(num));
    }

    public static int longestConsecutive(int[] num) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>(num.length);
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                result = Math.max(sum, result);
                map.put(n, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return result;
    }
}
