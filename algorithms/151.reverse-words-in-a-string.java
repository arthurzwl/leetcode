/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverseWords(chars);
        return cleanSpace(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    private void reverseWords(char[] chars) {
        int i = 0, j = 0;
        int n = chars.length;
        while (j < n) {
            while (i < j || i < n && chars[i] == ' ') i++;
            while (j < i || j < n && chars[j] != ' ') j++;
            reverse(chars, i, j - 1);
        }
    }

    private String cleanSpace(char[] chars) {
        int i = 0, j = 0;
        int n = chars.length;
        while (j < n) {
            while (j < n && chars[j] == ' ') j++;
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') j++;
            if (j < n) chars[i++] = ' ';
        }
        return new String(chars).substring(0, i);
    }
}

