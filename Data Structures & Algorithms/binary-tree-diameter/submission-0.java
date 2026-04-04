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
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return res;
    }
       private int dfs(TreeNode root){
        if(root==null )return 0;
         int leftH=dfs(root.left);
        int rightH=dfs(root.right);
        res=Math.max(leftH+rightH,res);
        return 1+Math.max(leftH,rightH);
    }
}
