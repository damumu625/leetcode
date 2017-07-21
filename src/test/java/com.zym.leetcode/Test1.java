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

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class Test1 {
    @Test
    public void test() {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("test", 1);
        HashMap<String, Integer> map2 = (HashMap) map1.clone();
        map2.put("test", 2);
        System.out.print(map1.get("test"));
    }

    @Test
    public void test2() {
        int i = 1;
        System.out.print((i++));
        System.out.print(i);
        System.out.print("2"+3+4);
    }

    @Test
    public void test3() {
        String clusterAddress = "10.153.90.2:2181,10.153.90.3:2181,10.153.90.4:2181,10.153.90.5:2181";
        int last2181 = clusterAddress.indexOf("2181");
        if (last2181 == -1) {
            last2181 = clusterAddress.indexOf("9092");
        }
        int lastComma = clusterAddress.substring(0, last2181).lastIndexOf("\"");
        String address = clusterAddress.substring(lastComma + 1, last2181) + "2181";
        System.out.println("address = " + address);
    }

    @Test
    public void test4() {
        Map<Integer, Integer> map = new HashMap<>(4);
        for (int i = 0; i < 16; i++) {
            map.put(i, i);
        }
        map.put(0, 0);
    }

    @Test
    public void test5() {
        int x = 1;
        float y = 2;
        System.out.println(x/y);
    }

    @Test
    public void test6() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(0,0);
        System.out.print(list);
    }

    @Test
    public void test7() {
        String s = "012345";
        System.out.println(s.substring(5,6));
    }

    @Test
    public void test8(){
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));

        /*BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for(BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0)
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);*/
        BigDecimal totalOfDiscountedPrices =
                prices.stream()
                        .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                        .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
        System.out.println(prices.stream().count());
     }
}
