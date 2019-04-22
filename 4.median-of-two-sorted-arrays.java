/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        boolean isOdd = length % 2 == 1;
        int pos = length / 2;
        if (nums1.length == 0 || nums2.length == 0) {
            int[] nums = nums1.length == 0 ? nums2 : nums1;
            if (isOdd) {
                return nums[pos];
            }
            return (nums[pos - 1] + nums[pos]) / 2.0;
        }
        int val1 = 0, val2 = 0, p1 = 0, p2 = 0;
        for (int i = 0; i <= pos; i++) {
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] < nums2[p2]) {
                    val1 = val2;
                    val2 = nums1[p1++];
                } else {
                    val1 = val2;
                    val2 = nums2[p2++];
                }
            } else if (p1 < nums1.length) {
                val1 = val2;
                val2 = nums1[p1++];
            } else {
                val1 = val2;
                val2 = nums2[p2++];
            }
        }
        if (isOdd) {
            return val2;
        }
        return (val1 + val2) / 2.0;
    }
}

