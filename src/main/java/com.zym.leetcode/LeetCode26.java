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
 判断一个字符串是否是回文，只考虑字母，忽略大小写
 */

public class LeetCode26 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        boolean result = true;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = chars[left];
            if (leftChar < '0' || (leftChar < 'A' && leftChar > '9') || leftChar > 'z' || (leftChar > 'Z' && leftChar < 'a')) {
                left++;
                continue;
            }
            if (leftChar <= 'Z' && leftChar >= 'A') {
                leftChar += 32;
            }
            char rightChar = chars[right];
            if (rightChar < '0' || (rightChar < 'A' && rightChar > '9') || rightChar > 'z' || (rightChar > 'Z' && rightChar < 'a')) {
                right--;
                continue;
            }
            if (rightChar <= 'Z' && rightChar >= 'A') {
                rightChar += 32;
            }
            if (leftChar != rightChar) {
                result = false;
                break;
            }
            left++;
            right--;

        }
        return result;
    }
}
