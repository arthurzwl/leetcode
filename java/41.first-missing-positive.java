/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0;i < nums.length;) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        int i = 1;
        while (i <= nums.length && i == nums[i - 1]) {
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}

