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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        // left
        int leftMax = Math.max(dfs(root.left), 0);

        // right
        int rightMax = Math.max(dfs(root.right), 0);

        //Tracks the best complete path across the entire tree
        max = Math.max(max, leftMax + rightMax + root.val);

        //Sends the current node's extendable gain to its parent
        return Math.max(leftMax, rightMax) + root.val;
    }
}
