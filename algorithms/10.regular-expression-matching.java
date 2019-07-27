/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */
class Solution {

    public boolean isMatch(String s, String p) {
        return isMatchDynamic(s, p);
    }

    /**
     * 动态规划
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchDynamic(String s, String p) {
        boolean[][] ans = new boolean[s.length() + 1][p.length() + 1];
        ans[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && ans[0][i - 1]) ans[0][i + 1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    ans[i + 1][j + 1] = ans[i][j];
                } else if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        ans[i + 1][j + 1] = ans[i + 1][j - 1];
                    } else {
                        ans[i + 1][j + 1] = ans[i + 1][j] || ans[i + 1][j - 1] || ans[i][j + 1];
                    }
                }
            }
        }
        return ans[s.length()][p.length()];
    }

    /**
     * 递归
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchRecursion(String s, String p) {
        Pattern pattern = new Pattern(p);
        return pattern.match(s);
    }

    class Pattern {
        String pattern;
        private boolean match;

        Pattern(String pattern) {
            this.pattern = pattern;
            this.match = false;
        }

        boolean match(String target) {
            match = false;
            doMatch(target, 0, 0);
            return match;
        }

        private void doMatch(String target, int tIdx, int pIdx) {
            if (match)
                return;
            if (tIdx >= target.length() && pIdx == pattern.length()) {
                match = true;
                return;
            }
            if (tIdx < target.length() && pIdx == pattern.length())
                return;
            char p = pattern.charAt(pIdx);
            boolean firstMatch = tIdx < target.length() && (p == target.charAt(tIdx) || p == '.');
            if (pIdx + 1 < pattern.length() && pattern.charAt(pIdx + 1) == '*') {
                doMatch(target, tIdx, pIdx + 2);
                if (firstMatch && tIdx < target.length()) {
                    doMatch(target, tIdx + 1, pIdx);
                }
            } else if (firstMatch && tIdx < target.length()) {
                doMatch(target, tIdx + 1, pIdx + 1);
            }
        }
    }
}

