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
        int left_max=Math.max(dfs(root.left),0);
        int right_max=Math.max(dfs(root.right),0);
        g_max=Math.max(g_max,left_max+right_max+root.val);
        return root.val+Math.max(left_max,right_max);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return g_max;
    }
}
