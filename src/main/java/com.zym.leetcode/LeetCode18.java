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
 克隆无向图
 1.广度优先
 2.深度优先
 */

import java.util.*;

public class LeetCode18 {

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node0.neighbors.add(node3);

        node1.neighbors.add(node0);
        node1.neighbors.add(node3);

        node2.neighbors.add(node0);
        node2.neighbors.add(node3);

        node3.neighbors.add(node0);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        System.out.println(cloneGraph1(node0));

    }

    public static UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        return cloneGraph1(node, new HashMap<>());
    }

    public static UndirectedGraphNode cloneGraph1(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph1(neighbor, map));
        }
        return newNode;
    }

    public static UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        if (node == null) {
            return node;
        }
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.pop();
            UndirectedGraphNode temp;
            for (UndirectedGraphNode neighbor : current.neighbors) {
                temp = map.get(neighbor.label);
                if (temp == null) {
                    temp = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor.label, temp);
                    queue.add(neighbor);
                }
                map.get(current.label).neighbors.add(temp);
            }
        }
        return newNode;
    }
}


class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}