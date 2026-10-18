/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int goodCountNode = 0;

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return goodCountNode;
    }

    private void helper(TreeNode root, int maxValue) {
        if (root == null)
            return;

        if (root.val >= maxValue) {
            maxValue = root.val;
            goodCountNode++;
        }

        if (root.left != null)
            helper(root.left, maxValue);
        if (root.right != null)
            helper(root.right, maxValue);

    }
}
