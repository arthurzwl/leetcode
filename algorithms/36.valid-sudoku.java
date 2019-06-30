/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] boxes = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int b = (r / 3) * 3 + c / 3;
                char val = board[r][c];
                if (val == '.') {
                    continue;
                }
                if (rows[r].contains(val) || columns[c].contains(val) || boxes[b].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                columns[c].add(val);
                boxes[b].add(val);
            }
        }
        return true;
    }
}

