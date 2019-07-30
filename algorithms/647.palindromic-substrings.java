/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        boolean[][] ans = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i + 1 < j) {
                    ans[i][j] = ans[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                } else if (i + 1 == j) {
                    ans[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    ans[i][j] = true;
                }
                if (ans[i][j]) count++;
            }
        }
        return count;
    }
}

