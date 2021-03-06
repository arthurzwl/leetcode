/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.09%)
 * Total Accepted:    604K
 * Total Submissions: 2.4M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        long absX = Math.abs((long)x);
        if (absX < 10) {
            return x;
        }
        long result = 0L;
        while(absX >= 10) {
            result = (result + absX % 10) * 10;
            absX /= 10;
            if (result != (int) result) {
                return 0;
            }
        }
        result += absX;
        result = isNegative ? -result : result;
        return (int)result == result ? (int) result : 0;
    }
}

