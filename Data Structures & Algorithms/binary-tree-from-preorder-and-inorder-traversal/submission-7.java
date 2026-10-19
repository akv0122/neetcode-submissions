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
    private int preorderIndex;
    private Map<Integer, Integer> inorderPositions;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderPositions = new HashMap<>();

        // record each value index of inorder for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        // no values in this range means subtree is empty
        if (left > right)
            return null;

        int rootValue = preorder[preorderIndex];
        preorderIndex++; 
        TreeNode root = new TreeNode(rootValue);

        // find root in order to split the subtree values
        int middle = inorderPositions.get(rootValue);

        // build left  and right subtree
        root.left = build(preorder, left, middle - 1);
        root.right = build(preorder, middle + 1, right);

        return root;
    }
}
