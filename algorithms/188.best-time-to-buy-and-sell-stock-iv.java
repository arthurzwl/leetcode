/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length <= 1) return 0;
        if (k >= prices.length / 2) return quickSolve(prices);
        int[][] profits = new int[2][prices.length];
        int pre = 0;
        int cur = 1;
        for (int kk = 1; kk <= k; kk++) {
            int tmp = profits[pre][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                int profit = tmp + prices[i];
                profits[cur][i] = Math.max(profit, profits[cur][i - 1]);
                tmp = Math.max(tmp, profits[pre][i] - prices[i]);
            }
            int tmpIdx = pre;
            pre = cur;
            cur = tmpIdx;
        }
        return profits[pre][prices.length - 1];
    }

    public int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}

