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
    返回这些句子。
 */

import java.util.*;

public class LeetCode11 {
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak(s, dict));
    }

    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        return splitString(s, dict, new HashMap<String, ArrayList<String>>());
    }

    private static ArrayList<String> splitString(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        ArrayList<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : dict) {
            if (s.startsWith(word)) {
                ArrayList<String> subList = splitString(s.substring(word.length()), dict, map);
                for (String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
