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
    int g_max=Integer.MIN_VALUE;
    int  dfs(TreeNode root){
        if(root==null)return 0;
        int lefth=dfs(root.left);
        int righth=dfs(root.right);
        g_max=Math.max(g_max,lefth+righth);
        return 1+Math.max(lefth,righth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return g_max;
    }
}
