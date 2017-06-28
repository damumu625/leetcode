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
 给定一个字符串s,拆分成若干回文的字符串，返回最小的切割次数
 */

import java.util.HashMap;
import java.util.Map;

public class LeetCode19 {
    public static void main(String[] args) {
        System.out.println(minCut("aaaaaddc"));
    }

    public static int minCut(String s) {
        return minCut(s, new HashMap<String, Integer>());
    }

    public static int minCut(String s, Map<String, Integer> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int length = s.length();
        int cut = length - 1;
        for (int i = length; i >= 1; i--) {
            if (check(s.substring(0, i))) {
                if (i == length) {
                    cut = 0;
                    break;
                }
                cut = Math.min(cut, minCut(s.substring(i, length), map) + 1);
            }
        }
        map.put(s, cut);
        return cut;
    }

    private static boolean check(String sub) {
        int length = sub.length();
        boolean result = true;
        int start = 0;
        int end = length;
        while (start < end) {
            if (!sub.substring(start, start + 1).equals(sub.substring(end - 1, end))) {
                result = false;
                break;
            }
            start++;
            end--;
        }
        return result;
    }
}
