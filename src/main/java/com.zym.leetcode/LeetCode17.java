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
 在一条环形公路上有n个加油站，加油站i有gas[i]天然气，一辆车从加油站i到达加油站i+1
 需要消耗cost[i]天然气，有一辆初始天然气为空的汽车，汽车从何处出发，可以绕公路一周
 保证至多有1种解，如果没有返回-1。
 思路1：(1) 如果A点不能到达B点，则A,B之间的所有点都不能到达B（B是A第一个不能到达的点）
        (2) 如果天然气总数大于等于消耗总数，则至少有一解。（下面答案循环结束时start到n的
            位置是可达到的，多出来的天然气大于等于从0到start说缺少的天然气）

 思路2：初始start在end前一步，当能量充足时，end向前一步，能量不足时，start向后退一步
        当start与end重合时，如果剩余能量大于等于0，解可行。
 */

public class LeetCode17 {
    public static void main(String[] args) {
        int[] gas = {2, 5, 3, 7};
        int[] cost = {3, 6, 2, 6};
        System.out.println(canCompleteCircuit2(gas, cost));
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int tank, total, start;
        tank = total = start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return total + tank < 0 ? -1 : start;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int tank = gas[start] - cost[start];
        while (start != end) {
            if (tank >= 0) {
                tank += (gas[end] - cost[end]);
                end++;
            } else {
                start--;
                tank += (gas[start] - cost[start]);
            }
        }
        return tank < 0 ? -1 : start;
    }
}
