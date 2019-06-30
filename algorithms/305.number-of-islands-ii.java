/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */
class Solution {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m, n);
        List<Integer> totals = new ArrayList<>();
        for (int[] position : positions) {
            totals.add(unionFind.addPosition(position));
        }
        return totals;
    }

    private class UnionFind {
        int[][] grid;
        int[] pre;
        int total;
        int m;
        int n;

        UnionFind (int m, int n) {
            grid = new int[m][n];
            pre = new int[n*m];
            total = 0;
            this.m = m;
            this.n = n;
        }

        int find (int root) {
            if (pre[root] == root) {
                return root;
            }
            int current = root;
            while (pre[root] != root) {
                root = pre[root];
            }
            while (pre[current] != root) {
                int tmp = pre[current];
                pre[current] = root;
                current = tmp;
            }
            return root;
        }

        int join(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                pre[rootX] = rootY;
            }
            return rootY;
        }

        int addPosition(int[] position) {
            int r = position[0];
            int c = position[1];
            if (grid[r][c] == 1) return total;
            total++;
            int index = c + r * n;
            grid[r][c] = 1;
            pre[index] = index;
            int root = index;
            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                int upRoot = find(index - n);
                root = join(root, upRoot);
                total--;
            }
            if (r + 1 < m && grid[r + 1][c] == 1) {
                int downRoot = find(index + n);
                if (root != downRoot) {
                    root = join(root, downRoot);
                    total--;
                }
            }
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                int leftRoot = find(index - 1);
                if (root != leftRoot) {
                    root = join(root, leftRoot);
                    total--;
                }
            }
            if (c + 1 < n && grid[r][c + 1] == 1) {
                int rightRoot = find(index + 1);
                if (root != rightRoot) {
                    root = join(root, rightRoot);
                    total--;
                }
            }
            return total;
        }
    }
}