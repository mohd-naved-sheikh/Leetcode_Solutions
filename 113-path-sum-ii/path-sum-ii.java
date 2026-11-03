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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root,targetSum,0,output, new ArrayList<>());
        return output;
    }
     public void dfs(TreeNode root, int targetSum,int currentSum,List<List<Integer>> output,List<Integer> current) {
        if(root==null){
            return;
        }
        
        current.add(root.val);
        if(root.left==null && root.right==null && targetSum - root.val==0){
            output.add(new ArrayList(current));
        }
        dfs(root.left, targetSum-root.val, currentSum,output,current);
        
        dfs(root.right, targetSum-root.val, currentSum,output,current);

        current.remove(current.size() - 1);
    }
}