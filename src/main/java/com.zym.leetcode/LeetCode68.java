package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/25.
 */
/*
 假设一个升序排列的数组在一个未知的位置翻转，
 例如{0,1,2,3,4,5}变成了{4,5,0,1,2,3},在翻转后的数组中
 查找是否存在某一个数。可能存在重复的值
 不重复可用search,重复用search1
 */
public class LeetCode68 {
    public static void main(String[] args) {
        int[] A = {2,2,2,0,2,2};
        int target = 0;
        System.out.println(search1(A, target));
    }

    public static boolean search(int[] A, int target) {
        int length = A.length;
        if (length == 0) {
            return false;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (A[middle] >= A[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        int rot = left;
        left = 0;
        right = length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int realMiddle = (middle + rot) % length;
            if (A[realMiddle] == target) {
                return true;
            } else if (A[realMiddle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    public static boolean search1(int[] A, int target) {
        int length = A.length;
        if (length == 0) {
            return false;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (A[middle] == target){
                return true;
            }else if (A[middle] > A[right]){
                if (A[middle] > target && A[left] <= target){
                    right = middle;
                }else {
                    left = middle + 1;
                }
            }else if (A[middle] < A [right]){
                if (A[middle] < target && A[right] >= target){
                    left = middle + 1;
                }else {
                    right = middle;
                }
            }else {
                right -- ;
            }
        }
        return A[left] == target;
    }
}
