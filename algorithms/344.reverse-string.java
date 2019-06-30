/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */
class Solution {
    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        int left = 0, right = s.length - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}

