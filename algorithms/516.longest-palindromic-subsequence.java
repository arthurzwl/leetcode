/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] ans = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            ans[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                ans[i][j] = s.charAt(i) == s.charAt(j) ? ans[i + 1][j - 1] + 2 : Math.max(ans[i + 1][j], ans[i][j - 1]);
            }
        }
        return ans[0][len - 1];
    }
}

