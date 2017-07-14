package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/10.
 */

/*
 有一个数组，其中第i个元素是第i天给定股票的价格。
 设计一个算法来找到最大的利润。 您最多可以完成两个交易。
 注意：
 您可能不会同时从事多个交易（即，您必须在再次购买之前出售股票）。
 */
public class LeetCode28 {
    public static void main(String[] args) {
        int[] prices = {5, 2, 3, 4, 3, 2, 4, 4, 5, 1, 6};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, max1 = 0, max2 = 0;
        for (int price : prices) {
            min1 = Math.min(min1, price);
            max1 = Math.max(max1, price - min1);
            min2 = Math.min(min2, price - max1);
            max2 = Math.max(max2, price - min2);
        }
        return max2;
    }
}

