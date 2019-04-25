/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minSum = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int x = sum - target;
                if (Math.abs(minSum - target) > Math.abs(x)) {
                    minSum = sum;
                }
                if (x == 0) {
                    return sum;
                } else if (x > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return minSum;
    }
}

