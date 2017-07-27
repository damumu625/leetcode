package com.zym.leetcode;

import java.util.Stack;

/**
 * Created by damumu on 2017/7/27.
 */
/*
 给定一个文件的绝对路径（UNIX样式），简化它。
例如,path = "/home/" 返回"/home"
     path="/a/./b/../../c/" 返回"/c"
特殊情况：
     path="/../" 返回"/"
     path="/home//foo/" 返回"/home/foo"
 */
public class LeetCode78 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
    }
    public static String simplifyPath(String path) {
        String[] strings = path.split("/");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(".")) {
                strings[i] = "";
            }
            if (strings[i].equals("..")) {
                strings[i] = "";
                int temp = i;
                while (temp-- > 0) {
                    if (!strings[temp].equals("")) {
                        strings[temp] = "";
                        break;
                    }
                }
            }
        }
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                result += "/" + strings[i];
            }
        }
        return result.equals("") ? "/" : result;
    }
}
