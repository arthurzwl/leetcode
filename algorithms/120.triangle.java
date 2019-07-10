/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int high = triangle.size();
        int i = 0;
        int[][] values = new int[2][high];
        int cur = 0;
        int pre = 1;
        for (List<Integer> row : triangle) {
            int j = 0;
            for (Integer value : row) {
                if (i != 0) {
                    if (j > 0 && j < i) {
                        values[cur][j] = value + Math.min(values[pre][j - 1], values[pre][j]);
                    } else if (j == 0) {
                        values[cur][j] = value + values[pre][j];
                    } else {
                        values[cur][j] = value + values[pre][j - 1];
                    }
                } else {
                    values[cur][0] = value;
                }
                j++;
            }
            int tmp = cur;
            cur = pre;
            pre = tmp;
            i++;
        }
        int min = values[pre][0];
        for (i = 1; i < high; i++) {
            min = Math.min(min, values[pre][i]);
        }
        return min;
    }
}

