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
        boolean[][] isMatched = new boolean[s.length() + 1][p.length() + 1];
        isMatched[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            isMatched[0][i + 1] = p.charAt(i) == '*' && isMatched[0][i - 1];
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    isMatched[i][j] = isMatched[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    isMatched[i][j] = j - 2 >= 0 && isMatched[i][j - 2]
                    || (isMatched[i - 1][j] || isMatched[i][j - 1] || isMatched[i][j - 2]) && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1));
                }
            }
        }
        return isMatched[s.length()][p.length()];
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

