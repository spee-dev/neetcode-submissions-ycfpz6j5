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
    int dfs(TreeNode root){
        if(root==null)return 0;
        int leftH=(Math.max(dfs(root.left),0));
        int rightH=(Math.max(dfs(root.right),0));
        g_max=Math.max(g_max,leftH+rightH+root.val);
        return root.val+Math.max(leftH,rightH);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return g_max;
    }
}
