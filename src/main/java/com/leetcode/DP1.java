package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 * 输出: [0,0,1]
 *
 * @author mai.gq
 * @date 2020/7/22
 */
public class DP1 {
    private int m;
    private int n;
    private int[][] grid;

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        dfs(0, 0, new boolean[m][n], ansList);
        return ansList;
    }

    private boolean dfs( int i, int j, boolean[][] visited,List<List<Integer>> pathList) {
        if (i >= m || j >= n || grid[i][j] == 1 || visited[i][j]) {
            return false;
        }
        pathList.add(Arrays.asList(i, j));
        if ((i == m - 1) && (j == n-1) && grid[i][j] == 0) {
            return true;
        }
        visited[i][j] = true;
        if (dfs( i + 1, j,visited, pathList) || dfs( i, j + 1,visited, pathList)) {
            return true;
        }
        pathList.remove(pathList.size() - 1);
        return false;
    }
}
