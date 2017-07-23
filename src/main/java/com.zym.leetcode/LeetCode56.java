package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/23.
 */
/*
 给定一个数字串，返回所有可能的ip列表
 例如:给定"25525511135",返回["255.255.11.135", "255.255.111.35"].
 */
public class LeetCode56 {
    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }

    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int i1 = 1; i1 < s.length() - 2; i1++) {
            String s1 = s.substring(0, i1);
            if (!check(s1)) {
                continue;
            }
            for (int i2 = i1 + 1; i2 < s.length() - 1; i2++) {
                String s2 = s.substring(i1, i2);
                if (!check(s2)) {
                    continue;
                }
                for (int i3 = i2 + 1; i3 < s.length(); i3++) {
                    String s3 = s.substring(i2, i3);
                    if (!check(s3)) {
                        continue;
                    }
                    String s4 = s.substring(i3, s.length());
                    if (!check(s4)) {
                        continue;
                    }
                    result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return result;
    }

    private static boolean check(String s) {
        return s.length() <= 3 && !(s.length() >= 2 && s.charAt(0) == '0') && Integer.parseInt(s) <= 255;
    }
}
