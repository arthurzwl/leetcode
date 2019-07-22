/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1chars = new int[26];
        int[] s2chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1chars[s1.charAt(i) - 'a']++;
            s2chars[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1chars, s2chars)) return true;
            s2chars[s2.charAt(i) - 'a']--;
            s2chars[s2.charAt(i + s1.length()) - 'a']++;
        }
        return matches(s1chars, s2chars);
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i< 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}

