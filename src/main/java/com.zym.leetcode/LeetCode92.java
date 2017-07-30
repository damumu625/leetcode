package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 给定一个由大小写字母和空格组成的字符串，返回最后一个单词的长度
 如果最后一个单词不存在，返回0。
 例如：给定s = "Hello World", 返回5
 */
public class LeetCode92 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World "));
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
            } else if (result != 0) {
                break;
            }
        }
        return result;
    }
}
