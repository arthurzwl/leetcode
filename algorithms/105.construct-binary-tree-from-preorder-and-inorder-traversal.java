/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                int len = i - inStart;
                root.left = buildTree(preorder, preStart + 1, preStart + len, inorder, inStart, i - 1);
                root.right = buildTree(preorder, preStart + len + 1, preEnd, inorder, i + 1, inEnd);
                break;
            }
        }
        return root;
    }
}

