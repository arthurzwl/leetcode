/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            boolean notValid = false;
            if (notValid(startChar)) {
                start++;
                notValid = true;
            }
            if (notValid(endChar)) {
                end--;
                notValid = true;
            }
            if (notValid) {
                continue;
            }
            if (!charEquals(startChar, endChar)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean notValid(char c) {
        return !(c >= 'a' && c <= 'z' || c >= 'A' && c<= 'Z' || c >= '0' && c <= '9');
    }

    private boolean charEquals(char a, char b) {
        return a == b || Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}

