/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int index, int target, List<Integer> currentResult, List<List<Integer>> result) {
        if (index < candidates.length - 1 && candidates[index + 1] <= target) {
            combinationSum(candidates, index + 1, target, new ArrayList<>(currentResult), result);
        }
        int sum = 0;
        int candidate = candidates[index];
        while (sum <= target) {
            sum += candidate;
            currentResult.add(candidate);
            if (sum > target) {
                return;
            } else if (sum == target) {
                result.add(currentResult);
                return;
            } else if (index < candidates.length - 1 && candidates[index + 1] + sum <= target) {
                combinationSum(candidates, index + 1, target - sum, new ArrayList<>(currentResult), result);
            }
        }
    }
}

