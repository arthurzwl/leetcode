import java.util.Arrays;

/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {

    private static final String nullVal = ".";
    private static final String delm = "|";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(delm).append(node == null ? nullVal : node.val);
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("\\" + delm);
        Queue<TreeNode> queue = new LinkedList<>();
        String rootVal = values[0];
        if (nullVal.equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(rootVal));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String leftVal = values[i++];
            String rightVal = values[i++];
            if (!nullVal.equals(leftVal)) {
                TreeNode left = new TreeNode(Integer.valueOf(leftVal));
                node.left = left;
                queue.add(left);
            }
            if (!nullVal.equals(rightVal)) {
                TreeNode right = new TreeNode(Integer.valueOf(rightVal));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

