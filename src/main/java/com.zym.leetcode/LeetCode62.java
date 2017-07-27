package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/24.
 */
/*
 给定一个字符串S1，我们可以将其表示为一个二叉树划分为两个非空的子字符串递归。
 下面是"great"一个可能的表示： great    选择任意一个非叶子节点的节点，交换它的孩子节点rgeat
                              /    \                                                 /    \
                             gr    eat                                              rg    eat
                            / \    / \                                             / \    /  \
                           g   r  e   at                                          r   g  e   at
                                      / \                                                    / \
                                     a   t                                                  a   t
 我们称"rgeat"是"great"的拓展字符串，如果继续交换"rgeat"的"eat"和"at"会得到"rgtae",同样
 "rgtae"是"great"的拓展字符串，给定两个同样长度的s1和s2，判断s2是否是s1的拓展字符串
 */
public class LeetCode62 {
    public static void main(String[] args) {
        System.out.println(isScramble("abc", "bca"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;
        int size = s1.length();
        for (int i = 1; i < size; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }
        return false;
/*        if (size % 2 == 0) {
            return (isScramble(s1.substring(0, size / 2), s2.substring(size / 2, size))
                    && isScramble(s1.substring(size / 2, size), s2.substring(0, size / 2)))
                    || (isScramble(s1.substring(0, size / 2), s2.substring(0, size / 2))
                    && isScramble(s1.substring(size / 2, size), s2.substring(size / 2, size)));
        } else {
            return (isScramble(s1.substring(0, size / 2), s2.substring(0, size / 2))
                    && isScramble(s1.substring(size / 2, size), s2.substring(size / 2, size)))
                    || (isScramble(s1.substring(0, size / 2 + 1), s2.substring(0, size / 2 + 1))
                    && isScramble(s1.substring(size / 2 + 1, size), s2.substring(size / 2 + 1, size)))
                    || (isScramble(s1.substring(0, size / 2), s2.substring(size / 2 + 1, size))
                    && isScramble(s1.substring(size / 2, size), s2.substring(0, size / 2 + 1)))
                    || (isScramble(s1.substring(0, size / 2 + 1), s2.substring(size / 2, size))
                    && isScramble(s1.substring(size / 2 + 1, size), s2.substring(0, size / 2)));
        }*/
    }
}
