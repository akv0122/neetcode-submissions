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

    private int preIndex = 0; 
    private int inIndex = 0; 
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {    

        return helper(preorder, inorder, Integer.MAX_VALUE); 
        
    }


    private TreeNode helper(int[] preorder, int[] inorder, int limit){

        if(preIndex >= preorder.length) return null; 

        if(inorder[inIndex] == limit) {
            inIndex++; 
            return null; 
        }

        TreeNode root = new TreeNode(preorder[preIndex]); 
        preIndex++; 

        root.left = helper( preorder, inorder, root.val);
        root.right = helper(preorder, inorder, limit);  


        return root; 




    }




}
