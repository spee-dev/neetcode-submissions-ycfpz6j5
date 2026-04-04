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
    int dfs(TreeNode root){
        if(root==null)return 0;
        int lefth=dfs(root.left);
        if(lefth==-1)return -1;
        int righth=dfs(root.right);
        if(righth==-1)return -1;
        if(Math.abs(lefth-righth)>1)return -1;
        return 1+Math.max(lefth,righth);
    }
    public boolean isBalanced(TreeNode root) {
        return dfs(root)!=-1;
    }
}
