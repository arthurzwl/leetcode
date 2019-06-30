/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 * 
 * Time Complexity O(n * m)
 * Space Complexity O(n * m)
 */
class Solution {

    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0) {
            return 0;
        }
        int c = grid[0].length;
        if (c == 0) {
            return 0;
        }
        int total = r * c;
        int[] pre = new int[total];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int idx = i * c + j;
                if (grid[i][j] == '0') {
                    total--;
                } else {
                    pre[idx] = idx;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        pre[idx] = idx - c;
                        total--;
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        int leftRoot = unionSearch(pre, idx - 1);
                        int currentRoot = unionSearch(pre, idx);
                        if (leftRoot != currentRoot) {
                            pre[currentRoot] = leftRoot;
                            total--;
                        }
                    }
                }
            }
        }
        return total;
    }

    private int unionSearch(int[] pre, int root) {
        if (pre[root] == root) {
            return root;
        }
        int tmp;
        int current = root;
        while (root != pre[root]) {
            root = pre[root];
        }
        while (pre[current] != root) {
            tmp = pre[current];
            pre[current] = root;
            current = tmp;
        }
        return root;
    }
}
