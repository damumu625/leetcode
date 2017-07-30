package com.zym.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by damumu on 2017/7/29.
 */
/*
 给定若干区间，合并相连的区间
 例如：给定[1,3],[2,6],[8,10],[15,18],
       返回[1,6],[8,10],[15,18].
 */
public class LeetCode94 {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval i0 = new Interval(1, 9);
        Interval i1 = new Interval(2, 6);
        Interval i2 = new Interval(5, 8);
        Interval i3 = new Interval(15, 18);
        intervals.add(i0);
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        ArrayList<Interval> result = merge(intervals);
        for (Interval interval:result){
            System.out.println("start = " + interval.start + ", end = " + interval.end);
        }
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
            if (i == intervals.size() - 1) {
                break;
            }
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
