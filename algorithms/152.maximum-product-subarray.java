/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {
        int r = nums[0];
        int max = r;
        int min = r;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int product1 = num * max;
            int product2 = num * min;
            max = Math.max(num, Math.max(product1, product2));
            min = Math.min(num, Math.min(product1, product2));
            r = Math.max(r, max);
        }
        return r;
    }
}

