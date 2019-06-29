import java.util.*;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0 || target == 0) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum2(int[] candidates, int index, int target, List<Integer> currentResult, List<List<Integer>> result) {
        int nextIndex = index + 1;
        int candidate = candidates[index];
        while (nextIndex < candidates.length) {
            if (candidate != candidates[nextIndex]) {
                if (candidates[nextIndex] <= target) {
                    combinationSum2(candidates, nextIndex, target, new ArrayList<>(currentResult), result);
                }
                break;
            }
            nextIndex++;
        }
        target -= candidate;
        currentResult.add(candidate);
        if (target > 0 && index + 1 < candidates.length && candidates[index + 1] <= target) {
            combinationSum2(candidates, index + 1, target, currentResult, result);
        } else if (target == 0) {
            result.add(currentResult);
        }
    }
}

