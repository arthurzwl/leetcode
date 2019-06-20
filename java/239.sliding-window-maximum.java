import java.util.ArrayDeque;
import java.util.Deque;
/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1){
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[queue.peek()];
            }
        }
        return result;
    }
}

