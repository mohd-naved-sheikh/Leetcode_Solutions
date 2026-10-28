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
    public TreeNode invertTree(TreeNode root) {
             TreeNode current = root;
             if(root==null){
                return null;
             } 

               invertTree(current.left);
               invertTree(current.right);
               TreeNode temp =  current.left ;
               current.left = current.right;
               current.right = temp;
               
             return root;
    }
}