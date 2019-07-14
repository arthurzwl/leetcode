/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            if (cur != null) {
                result.addFirst(cur.val);
                if (cur.left != null) deque.add(cur.left);
                cur = cur.right;
            } else {
                cur = deque.pollLast();
            }
        }
        return result;
    }
}

