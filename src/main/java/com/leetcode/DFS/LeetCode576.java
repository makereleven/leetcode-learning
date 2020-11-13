package com.leetcode.DFS;

/**
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 * 解释:
 * <p>
 * 示例 2：
 * <p>
 * 输入: m = 1, n = 3, N = 3, i = 0, j = 1
 * 输出: 12
 * 解释:
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 球一旦出界，就不能再被移动回网格内。
 * 网格的长度和高度在 [1,50] 的范围内。
 * N 在 [0,50] 的范围内。
 *
 * @author mai.gq
 * @date 2020/11/13
 */
public class LeetCode576 {
    int m;
    int n;
    int modularity = 1000000007;
    Long[][][] mem;

    public int findPaths(int m, int n, int N, int i, int j) {
        mem = new Long[N + 1][m][n];
        this.m = m;
        this.n = n;
        return (int) (f(N, i, j) % modularity);
    }

    public Long f(int N, int i, int j) {
        if (N < 0) return 0L;
        if (N == 0) {
            if (i < 0 || i >= m || j < 0 || j >= n) return 1L;
            return 0L;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) return 1L;
        if (mem[N][i][j] != null) return mem[N][i][j];
        Long i1 = (f(N - 1, i + 1, j)
                + f(N - 1, i - 1, j)
                + f(N - 1, i, j + 1)
                + f(N - 1, i, j - 1)) % modularity;
        mem[N][i][j] = i1;
        return i1;
    }

}
