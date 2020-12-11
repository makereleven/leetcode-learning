package com.leetcode.BFS;

import javax.xml.soap.Node;
import java.util.*;

/**
 * BFS框架
 *
 * @author mai.gq
 * @date 2020/12/9
 */
public class BFS {
    //计算从起点到重点的最近距离BFS
    public int BFS(Node start, Node target) {

        Queue<Node> queue = new LinkedList<>(); // 核心数据结构
        Set<Node> visited = new HashSet<>(); // 避免走回头路

        queue.add(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                Node cur = queue.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                    return step;
                /* 将 cur 的相邻节点加入队列 */

            }
            res.add(tmp);
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }
}
