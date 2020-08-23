package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/7/17
 */
public class Shengzi {
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i-j] * j, j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
}
