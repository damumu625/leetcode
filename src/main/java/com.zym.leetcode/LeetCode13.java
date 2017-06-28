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
    链表的每个节点包含一个随机的指针，指向链表中的任意一个节点或者Null，
    深拷贝这个链表
    方法1.把老节点和对应的新节点放在map中
    方法2.每个新节点插入到每个老节点的后面
 */

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {
    public static void main(String[] args) {
        RandomListNode r0 = new RandomListNode(0);
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        RandomListNode r4 = new RandomListNode(4);
        r0.next = r1;
        r0.random = r4;
        r1.next = r2;
        r1.random = r3;
        r2.next = r3;
        r3.next = r4;
        RandomListNode result = copyRandomList2(r0);
        System.out.println(result);
    }

    //方法1
    public static RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode randomListNode = new RandomListNode(head.label);
        map.put(head, randomListNode);
        RandomListNode temp1 = head.next;
        RandomListNode temp2 = randomListNode;
        while (temp1 != null) {
            temp2.next = new RandomListNode(temp1.label);
            temp2 = temp2.next;
            map.put(temp1, temp2);
            temp1 = temp1.next;
        }
        while (head != null) {
            map.get(head).random = head.random;
            head = head.next;
        }
        return randomListNode;
    }

    //方法2
    public static RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode temp1, temp2;
        temp1 = head;
        while (temp1 != null) {
            temp2 = new RandomListNode(temp1.label);
            temp2.next = temp1.next;
            temp1.next = temp2;
            temp1 = temp2.next;
        }
        temp1 = head;
        while (temp1 != null) {
            if(temp1.random != null){
                temp1.next.random = temp1.random.next;
            }
            temp1 = temp1.next.next;
        }
        temp1 = head;
        RandomListNode copy;
        while (temp1.next.next != null){
            copy = temp1.next.next;
            temp1.next.next = copy.next;
            temp1 = copy;
        }
        return head.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
