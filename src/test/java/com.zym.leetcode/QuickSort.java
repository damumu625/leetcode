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

public class QuickSort {
    public static void main(String[] args) {
        int[] array1 = new int[1000000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int) (Math.random() * 10000);
        }
        long start = System.currentTimeMillis();
        quickSort(array1);
        long end = System.currentTimeMillis();
        System.out.println(end - start+"ms");
        int[] array = {10, 3, 6, 4, 8, 2, 7, 3, 9, 1};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void quickSort(int[] array) {
        quickSort(0, array.length - 1, array);
    }

    public static void quickSort(int left, int right, int[] array) {
        if (left >= right) {
            return;
        }
        int middle = middle(left, right, array);
        quickSort(left, middle - 1, array);
        quickSort(middle + 1, right, array);
    }

    public static int middle(int left, int right, int[] array) {
        int min = left;
        int max = left;
        int temp = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < temp) {
                min++;
                if (max > left) {
                    int temp1 = array[i];
                    array[i] = array[max];
                    array[max] = temp1;
                    max++;
                }
            } else if (max == left) {
                max = i;
            }
        }
        array[left] = array[min];
        array[min] = temp;
        return min;
    }
}
