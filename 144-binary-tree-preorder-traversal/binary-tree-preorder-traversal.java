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
    public List<Integer> preorderTraversal(TreeNode root) {
        List <Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack <TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            result.add(n.val);
            if(n.right!=null){
                stack.push(n.right);
            }
             if(n.left!=null){
                stack.push(n.left);
            }
        }
        return result;
    }
}