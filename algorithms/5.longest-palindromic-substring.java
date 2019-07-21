/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */
class Solution {
    // 暴力法
    // public String longestPalindrome(String s) {
    //     if (s.length() <= 1) return s;
    //     int maxLen = 0;
    //     int maxStart = 0;
    //     int maxEnd = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         for (int j = i; j < s.length(); j++) {
    //             if (isPalindrome(s, i, j)) {
    //                 int len = j - i + 1;
    //                 if (len > maxLen) {
    //                     maxLen = len;
    //                     maxStart = i;
    //                     maxEnd = j;
    //                 }
    //             }
    //         }
    //     }
    //     return s.substring(maxStart, maxEnd + 1);
    // }

    // private boolean isPalindrome(String s, int start, int end) {
    //     while (start < end){
    //         if (s.charAt(start) != s.charAt(end)) return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }


    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int sLen = s.length();
        boolean ans[][] = new boolean[sLen][sLen];
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i; j < sLen; j++) {
                if (i + 1 < j) {
                    ans[i][j] = ans[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                    int len = j - i + 1;
                    if (ans[i][j] && len >= maxLen) {
                        maxLen = len;
                        maxStart = i;
                        maxEnd = j;
                    }
                } else if (i == j) {
                    ans[i][j] = true;
                } else {
                    ans[i][j] = s.charAt(i) == s.charAt(j);
                    int len = 2;
                    if (ans[i][j] && len >= maxLen) {
                        maxLen = len;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}

