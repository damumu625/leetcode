package com.zym.leetcode;

/**
 * Created by damumu on 2017/7/10.
 */

/*
 有一个数组，其中第i个元素是第i天给定股票的价格。
 设计一个算法来找到最大的利润。 您可以根据需求完成尽可能多的交易。
 注意：
 您可能不会同时从事多个交易（即，您必须在再次购买之前出售股票）。
 */
public class LeetCode29 {
    public static void main(String[] args) {
        int[] prices = {5, 2, 3, 4, 3, 2, 4, 4, 5, 1, 6};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int result = 0, change;
        for (int i = 0; i < prices.length - 1; i++) {
            change = prices[i + 1] - prices[i];
            if (change > 0) {
                result += change;
            }
        }
        return result;
    }
}