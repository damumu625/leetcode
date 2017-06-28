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
    给定一个字符串和一组字典，在字符串中添加空格，
    构成一个句子，保证每个单词都在字典中。
    判断字符串能否构成句子
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode12 {
    public static void main(String[] args) {
        String s = "aaaaa";
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aaa");
        System.out.println(wordBreak(s, dict));
    }
    public static boolean wordBreak(String s, Set<String> dict) {
        return splitString(s, dict, new HashMap<String, Boolean>());
    }

    private static boolean splitString(String s, Set<String> dict, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        boolean result = false;
        if (s.length() == 0) {
            return true;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                result = splitString(s.substring(word.length()), dict, map);
                if(result){
                    break;
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
