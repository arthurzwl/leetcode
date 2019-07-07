/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] profits = new int[4][prices.length];
        profits[0][0] = prices[0];
        profits[1][0] = 0;
        profits[2][0] = -prices[0];
        profits[3][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - profits[0][i - 1];
            int price = profits[1][i - 1] - prices[i];
            int finalProfit = prices[i] + profits[2][i - 1];
            profits[0][i] = Math.min(prices[i], profits[0][i - 1]);
            profits[1][i] = Math.max(profit, profits[1][i - 1]);
            profits[2][i] = Math.max(price, profits[2][i - 1]);
            profits[3][i] = Math.max(finalProfit, profits[3][i - 1]);
        }
        return profits[3][prices.length - 1];
    }
}

