package com.leetcode;

/**
 * @author mai.gq
 * @date 2020/7/20
 */
public class Jianzhi63 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
