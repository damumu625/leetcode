package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/14.
 */

/*
 给定一个三角形，从顶部到底部找到最小路径和。 每个步骤，您可以移动到下面的行上的相邻数字。
 例如，给定以下三角形:[[2],     从顶部到底部路径最小的和是2+3+5+1。
                      [3,4],
                     [6,5,7],
                    [4,1,8,3]]
 最好是只使用O(n)的额外空间，其中n是三角形的行数。
 方法一：递归
 方法二：从下往上
 */
public class LeetCode31 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> t0 = new ArrayList<>();
        t0.add(2);
        ArrayList<Integer> t1 = new ArrayList<>();
        t1.add(3);
        t1.add(4);
        ArrayList<Integer> t2 = new ArrayList<>();
        t2.add(6);
        t2.add(5);
        t2.add(7);
        ArrayList<Integer> t3 = new ArrayList<>();
        t3.add(4);
        t3.add(1);
        t3.add(8);
        t3.add(3);
        triangle.add(t0);
        triangle.add(t1);
        triangle.add(t2);
        triangle.add(t3);
        long time1 = System.nanoTime();
        System.out.println(minimumTotal1(triangle));
        long time2 = System.nanoTime();
        System.out.println(minimumTotal(triangle));
        long time3 = System.nanoTime();
        System.out.println(time2 - time1);
        System.out.println(time3 - time2);
    }

    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        return minimumTotal(0, 0, triangle);
    }

    public static int minimumTotal(int i, int j, ArrayList<ArrayList<Integer>> triangle) {
        if (i == triangle.size()) {
            return 0;
        }
        int left = minimumTotal(i + 1, j, triangle);
        int right = minimumTotal(i + 1, j + 1, triangle);
        return triangle.get(i).get(j) + Math.min(left, right);
    }

    public static int minimumTotal1(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle.get(i - 1).set(j, triangle.get(i - 1).get(j) + Math.min(triangle.get(i).get(j), triangle.get(i).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
