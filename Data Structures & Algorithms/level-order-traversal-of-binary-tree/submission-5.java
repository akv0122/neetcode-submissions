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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> dq = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        dq.add(root);

        while (!dq.isEmpty()) {
            int levelSize = dq.size();
            List<Integer> levelArr = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = dq.remove();
                levelArr.add(temp.val);

                if (temp.left != null)
                    dq.add(temp.left);

                if (temp.right != null)
                    dq.add(temp.right);
            }

            result.add(levelArr);
        }

        return result;
    }
}
