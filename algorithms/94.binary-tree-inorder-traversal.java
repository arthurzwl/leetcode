/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        while (!queue.isEmpty() || cur != null) {
            if (cur != null) {
                queue.add(cur);
                cur = cur.left;
            } else if (!queue.isEmpty()) {
                cur = queue.pollLast();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}

