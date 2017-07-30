package com.zym.leetcode;

import java.util.ArrayList;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 给定一些没有交集的区间和一个区间，把该区间插入到集合中，如有重叠合并这些区间
 */
public class LeetCode93 {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval i0 = new Interval(1, 3);
        Interval i1 = new Interval(5, 7);
        Interval i2 = new Interval(9, 10);
        Interval i3 = new Interval(11, 12);
        Interval i4 = new Interval(2, 8);
        intervals.add(i0);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        ArrayList<Interval> result = insert(intervals, i4);
        for (Interval interval : result) {
            System.out.println("start = " + interval.start + ", end = " + interval.end);
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (newInterval.start <= interval.end && newInterval.end >= interval.start) {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
                intervals.remove(i);
                i--;
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}