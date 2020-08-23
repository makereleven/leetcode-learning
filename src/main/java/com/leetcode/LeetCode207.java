package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * @author mai.gq
 * @date 2020/8/4
 */
public class LeetCode207 {
    private List<List<Integer>> lists = new ArrayList<>();
    private boolean valid = true;
    private int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            lists.get(prerequisite[1]).add(prerequisite[0]);
        }
        visited = new int[numCourses];
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (Integer j : lists.get(i)) {
            if (visited[j] == 0) {
                dfs(j);
                if (!valid) {
                    return;
                }
            } else if (visited[j] == 1) {
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }
}
