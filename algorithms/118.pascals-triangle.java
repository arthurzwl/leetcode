import java.util.*;
/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        Integer[] pre = new Integer[0], row;
        for (int i = 0; i < numRows; i++) {
            row = new Integer[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    row[j] = 1;
                } else {
                    row[j] = pre[j - 1] + pre[j];
                }
            }
            pre = row;
            result.add(Arrays.asList(row));
        }
        return result;
    }
}

