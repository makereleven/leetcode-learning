package com.leetcode.DFS;

/**
 * 743. 网络延迟时间
 * 有 N 个网络节点，标记为 1 到 N。
 * <p>
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 * <p>
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 *
 * @author mai.gq
 * @date 2020/11/11
 */
public class LeetCode743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        return dfs(times, N, 0, K, 0);
    }

    private int dfs(int[][] times, int N, int n, int K, int res) {
        if (n == N) {
            return res;
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] == K) {
                res += times[i][2];
                n++;
                System.out.println(res);
                dfs(times, N, n, times[i][1], res);
            }
        }
        return -1;
    }
}
