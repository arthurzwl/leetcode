/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }


    public void levelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        List<Integer> levelResult;
        if (result.size() == level) {
            levelResult = new ArrayList<>();
            result.add(levelResult);
        } else {
            levelResult = result.get(level);
        }
        levelResult.add(node.val);
        levelOrder(node.left, level + 1, result);
        levelOrder(node.right, level + 1, result);
    }

}

