/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int val = 0;
            if (countMap.containsKey(c)) val = countMap.get(c);
            countMap.put(c, val + 1);
        }
        int singleVal = 0;
        int doubleVal = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            doubleVal += entry.getValue() / 2;
            singleVal = entry.getValue() % 2 == 1 ? 1 : singleVal;
        }
        return doubleVal * 2 + singleVal;
    }
}

