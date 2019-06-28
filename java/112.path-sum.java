/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int val = sum - root.val;
        if (root.left == null && root.right == null) {
            return val == 0;
        }
        return hasPathSum(root.left, val) || hasPathSum(root.right, val);
    }
}

