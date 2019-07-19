/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>((int) (inorder.length / 0.75) + 1);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(root.val);
        int len = idx - inStart;
        root.left = buildTree(inorder, inStart, idx - 1, postorder, postStart, postStart + len - 1, map);
        root.right = buildTree(inorder, idx + 1, inEnd, postorder, postStart + len, postEnd - 1, map);
        return root;
    }
}

