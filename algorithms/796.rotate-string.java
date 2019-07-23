/*
 * @lc app=leetcode id=796 lang=java
 * 
 * algorithm: RK
 *
 * [796] Rotate String
 */
class Solution {

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.length() == 0) return true;
        int len = A.length();
        long[] cache = new long[len];
        long c = 1L;
        cache[0] = c;
        for (int i = 1; i < len; i++) {
            c *= 26;
            cache[i] = c;
        }
        long aHash = str2Hash(A, 0);
        long bHash = str2Hash(B, 0);
        for (int i = 0; i < len; i++) {
            if (aHash == bHash && strEquals(A, B, i)) return true;
            int val = A.charAt(i) - 'a';
            aHash -= val * cache[len - 1];
            aHash = aHash * 26 + val;
        }
        return false;
    }

    private long str2Hash(String str, int start) {
        int len = str.length();
        int end = start + len;
        long hash = 0;
        for (int i = start; i < end; i++) {
            int idx = i % len;
            hash = hash * 26 + (str.charAt(idx) - 'a');
        }
        return hash;
    }

    private boolean strEquals(String a, String b, int aStart) {
        for (int i = 0; i < a.length(); i++) {
            int aIdx = (aStart + i) % a.length();
            if (a.charAt(aIdx) != b.charAt(i)) return false;
        }
        return true;
    }
}

