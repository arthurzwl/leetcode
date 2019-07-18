/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root, 0);
        return diameter;
    }

    private int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        int maxLeft = maxDepth(root.left, 1);
        int maxRight = maxDepth(root.right, 1);
        diameter = Math.max(diameter, maxLeft + maxRight);
        return depth + Math.max(maxLeft, maxRight);
    }


}

