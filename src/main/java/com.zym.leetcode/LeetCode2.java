/*******************************************************
 * Copyright (C) 2017 iQIYI.COM - All Rights Reserved
 * <p/>
 * This file is part of LeetCode project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * <p/>
 * Author(s): zhangyongming_sx <zhangyongming_sx@qiyi.com>
 *******************************************************/
package com.zym.leetcode;

import java.util.*;

public class LeetCode2 {
    public static void main(String[] args) {
        Point point1 = new Point(0, -12);
        Point point2 = new Point(5, 2);
        Point point3 = new Point(2, 5);
        Point point4 = new Point(0, -5);
        Point point5 = new Point(1, 5);
        Point point6 = new Point(2, -2);
        Point point7 = new Point(5, -4);
        Point point8 = new Point(3, -4);
        Point point9 = new Point(-2, 4);
        Point point10 = new Point(-1, 4);
        Point point11 = new Point(0, -5);
        Point point12 = new Point(0, -8);
        Point point13 = new Point(-2, -1);
        Point point14 = new Point(0, -11);
        Point point15 = new Point(0, -9);
        Point[] points = {point1, point2, point3,point4,point5, point6, point7,point8,
                point9, point10, point11,point12,point13, point14, point15};
        System.out.print(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {
        if (points.length == 0 || points.length == 1) {
            return points.length;
        }
        Map<Double, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Double t = null;
                if (points[i].x != points[j].x) {
                    t = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
                }
                Set<Integer> s = map.get(t);
                if (s == null) {
                    s = new HashSet<Integer>();
                    map.put(t, s);
                }
                s.add(i);
                s.add(j);
                if(s.size() == 12){
                    System.out.print("");
                }
            }
        }
        int result = 0;
        for (Set<Integer> v : map.values()) {
            result = result > v.size() ? result : v.size();
        }
        return result;
    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
