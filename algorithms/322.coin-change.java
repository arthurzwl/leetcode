/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] >= 0) {
                    dp[i] = dp[i] >= 0 ? Math.min(dp[i], dp[i - coins[j]] + 1)
                            : dp[i - coins[j]] + 1;
                }
            }
        }
        return dp[amount] >= 0 ? dp[amount] : -1;
    }
}

