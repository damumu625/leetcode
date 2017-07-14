package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/10.
 */

/*
 有一个数组，其中第i个元素是第i天给定股票的价格。
 设计一个算法来找到最大的利润。 您只能完成一次交易。
 注意：
 您可能不会同时从事多个交易（即，您必须在再次购买之前出售股票）。
 */
public class LeetCode30 {
    public static void main(String[] args) {
        int[] prices = {2, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}