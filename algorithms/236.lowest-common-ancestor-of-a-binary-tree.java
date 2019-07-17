/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return ans;
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (ans != null) return false;
        if (root == null) return false;
        int mid = 0, left = 0, right = 0;
        if (root == p || root == q) mid = 1;
        if (find(root.left, p, q)) left = 1;
        if (find(root.right, p, q)) right = 1;
        if (mid + left + right > 1) ans = root;
        return mid + left + right > 0;
    }
}

