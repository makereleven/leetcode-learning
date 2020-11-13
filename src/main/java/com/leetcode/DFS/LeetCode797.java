package com.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * <p>
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 示例 3：
 * <p>
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 * <p>
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 * <p>
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *  
 *
 * @author mai.gq
 * @date 2020/11/11
 */
public class LeetCode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList();
            path.add(N - 1);
            ans.add(path);
            return ans;
        }

        for (int nei : graph[node]) {
            for (List<Integer> path : solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] d = {{1, 2}, {3}, {3}, {}};
        LeetCode797 l = new LeetCode797();
        l.allPathsSourceTarget(d);
    }
}
