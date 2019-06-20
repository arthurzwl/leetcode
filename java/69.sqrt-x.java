/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */
class Solution {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

