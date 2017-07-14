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
 给定一个start和一个end字符串，和一个字典
 每次改变一个字母，把start转化成end，所有中间字符串必须在字典中
 输出把所有转换过程
 例如:start ="hit"
      end ="cog"
      dict =["hot","dot","dog","lot","log"]
 返回：
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class LeetCode24 {
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        String start = "hit";
        String end = "cog";
        System.out.println(findLadders(start, end, dict));
    }

    public static void findLadders(String start, String end, HashSet<String> dict, ArrayList<ArrayList<String>> list) {
        ArrayList<String> nextWords = nextWord(start, dict);
        for (String n : nextWords) {
            findLadders(n, end, dict, list);
        }
    }

    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        findLadders(start, end, dict, result);
        return result;
        /*ArrayList<ArrayList<String>> ladders = null;
        if (neighbor(start, end)) {
            ArrayList<String> l = new ArrayList<>();
            ladders = new ArrayList<>();
            ladders.add(l);
            return ladders;
        }
        ArrayList<String> nextWords = nextWord(start, dict);
        for (String n : nextWords) {
            ArrayList<ArrayList<String>> temp = findLadders(n, end, dict);
            if (temp == null) {
                continue;
            }
            for (ArrayList<String> ladder : temp) {
                if (ladder.contains(n)) {
                    temp.remove(ladder);
                } else {
                    ladder.add(0, n);
                }
            }
            if (temp.size() > 0) {
                ladders.addAll(temp);
            }
        }
        return ladders;*/
    }

    private static boolean neighbor(String start, String end) {
        boolean result = true;
        char[] starChars = start.toCharArray();
        char[] endChars = end.toCharArray();
        int diff = 0;
        for (int i = 0; i < starChars.length; i++) {
            if (starChars[i] != endChars[i]) {
                diff++;
                if (diff > 1) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private static ArrayList<String> nextWord(String start, HashSet<String> dict) {
        ArrayList<String> words = new ArrayList<>();
        char[] chars = start.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (ch == c) {
                    continue;
                }
                chars[i] = c;
                String word = String.valueOf(chars);
                if (dict.contains(word)) {
                    words.add(word);
                }
            }
            chars[i] = ch;
        }
        return words;
    }
}
