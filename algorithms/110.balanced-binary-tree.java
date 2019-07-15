/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return hight(root) >= 0;
    }

    public int hight(TreeNode node) {
        if (node == null) return 0;
        int leftHight = hight(node.left);
        if (leftHight < 0) return leftHight;
        int rightHight = hight(node.right);
        if (rightHight < 0 || Math.abs(leftHight - rightHight) > 1) return -1;
        return Math.max(leftHight, rightHight) + 1;
    }
}

