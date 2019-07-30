/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, isPalindrome(s, i, i));
            end = Math.max(end, isPalindrome(s, i, i + 1));
        }
        System.out.println(end);
        if (end + 1 == len) return s;
        StringBuilder sb = new StringBuilder(len + len - 1 - end);
        sb.append(s.substring(end + 1, len)).reverse().append(s);
        return sb.toString();
    }

    private int isPalindrome(String s, int start, int end) {
        int ret = -1;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            if (start == -1) ret = end - 1;
        }
        return ret;
    }
}

