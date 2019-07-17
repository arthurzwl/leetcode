/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min = p.val < q.val ? p : q;
        TreeNode max = min == p ? q : p;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val >= min.val && cur.val <= max.val) {
                return cur;
            } else if (cur.val > max.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return null;
    }
}

