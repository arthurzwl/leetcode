/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum3(int k, int n, int num, List<Integer> currentResult, List<List<Integer>> result) {
        if (num + k <= 9 && k * (num + 1) <= n) {
            combinationSum3(k, n, num + 1, currentResult, result);
        }
        n -= num;
        k--;
        currentResult.add(num);
        num++;
        if (n == 0 && k == 0) {
            result.add(new ArrayList<>(currentResult));
        } else if (n > 0 && k > 0 && k * num <= n && num + k <= 10) {
            combinationSum3(k, n, num, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}

