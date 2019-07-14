/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root != null) {
            deque.offerFirst(root);
        }
        while (!deque.isEmpty()) {
            TreeNode curNode = deque.poll();
            result.add(curNode.val);
            if (curNode.right != null) {
                deque.offerFirst(curNode.right);
            }
            if (curNode.left != null) {
                deque.offerFirst(curNode.left);
            }
        }
        return result;
    }
}

