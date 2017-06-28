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
 给定一个字符串s,拆分成若干回文的字符串，把所有情况列出来
 递归求解，方法二保存了已经计算过的字符串，但保留了list,占据更多的内存，节省了时间
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(partition("aaabbcaacbawgrhbrthwrhg"));
    }

    public static ArrayList<ArrayList<String>> partition(String s) {
        long t1 = System.nanoTime();
        partition1(s, new HashMap<String, Boolean>());
        long t2 = System.nanoTime();
        partition2(s, new HashMap<String, ArrayList<ArrayList<String>>>(), new HashMap<String, Boolean>());
        long t3 = System.nanoTime();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
        return null;
    }

    public static ArrayList<ArrayList<String>> partition1(String s, Map<String, Boolean> map1) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            if (check(s.substring(0, i), map1)) {
                if (i == s.length()) {
                    ArrayList<String> res = new ArrayList<>();
                    res.add(s.substring(0, i));
                    result.add(res);
                } else {
                    ArrayList<ArrayList<String>> arrays = partition1(s.substring(i, s.length()), map1);
                    for (ArrayList<String> array : arrays) {
                        array.add(0, s.substring(0, i));
                        result.add(array);
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<String>> partition2(String s, Map<String, ArrayList<ArrayList<String>>> map, Map<String, Boolean> map1) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            if (check(s.substring(0, i), map1)) {
                if (i == s.length()) {
                    ArrayList<String> res = new ArrayList<>();
                    res.add(s.substring(0, i));
                    result.add(res);
                } else {
                    ArrayList<ArrayList<String>> arrays = partition2(s.substring(i, s.length()), map, map1);
                    for (ArrayList<String> array : arrays) {
                        ArrayList<String> res = new ArrayList<>();
                        res.add(s.substring(0, i));
                        res.addAll(array);
                        result.add(res);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }

    private static boolean check(String sub, Map<String, Boolean> map1) {
        if (map1.containsKey(sub)) {
            return map1.get(sub);
        }
        int length = sub.length();
        if (length == 1) {
            return true;
        }
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
        map1.put(sub, result);
        return result;
    }
}
