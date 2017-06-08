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

import java.util.HashMap;

public class Test1 {
    @Test
    public void test(){
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("test", 1);
        HashMap<String, Integer> map2 = (HashMap)map1.clone();
        map2.put("test",2);
        System.out.print(map1.get("test"));
    }
}
