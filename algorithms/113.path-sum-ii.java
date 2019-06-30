/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        int val = sum - root.val;
        if (root.left == null && root.right == null) {
            if (val == 0) {
                currentResult.add(root.val);
                result.add(currentResult);
            }
            return;
        }
        if (root.left != null && root.right != null) {
            List<Integer> leftResult = new ArrayList<>(currentResult);
            leftResult.add(root.val);
            pathSum(root.left, val, leftResult, result);
            currentResult.add(root.val);
            pathSum(root.right, val, currentResult, result);
            return;
        }
        if (root.left != null) {
            currentResult.add(root.val);
            pathSum(root.left, val, currentResult, result);
        }
        if (root.right != null) {
            currentResult.add(root.val);
            pathSum(root.right, val, currentResult, result);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return Collections.emptyList();
        }
        int val = sum - root.val;
        if (root.left == null && root.right == null) {
            if (val == 0) {
                return Collections.singletonList(Collections.singletonList(root.val));
            } else {
                return Collections.emptyList();
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        if (root.left != null) {
            List<Integer> currentResult = new ArrayList<>();
            currentResult.add(root.val);
            pathSum(root.left, val, currentResult, result);
        }
        if (root.right != null) {
            List<Integer> currentResult = new ArrayList<>();
            currentResult.add(root.val);
            pathSum(root.right, val, currentResult, result);
        }
        return result;
    }
}
