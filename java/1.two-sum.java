import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int capacity = (int) (nums.length / 0.75 + 1);
        Map<Integer, Integer> map = new HashMap<>(capacity);
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                return new int[]{i, map.get(val)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

