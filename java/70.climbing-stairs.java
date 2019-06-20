/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2, c = a + b;
        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}

