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
    // TreeNode findLca(TreeNode root, TreeNode p, TreeNode q){
    //     if(root==null)return null;
    //     if(root==p || root==q)return root;
    //     TreeNode leftC=findLca(root.left,p,q);
    //     TreeNode rightC=findLca(root.right,p,q);
    //     if(leftC!=null && rightC!=null)return root;
    //     return leftC!=null?leftC:rightC;
    // }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current=root;
        while(current!=null){
            if(p.val<current.val && q.val<current.val){
                current=current.left;
            }
            else if(p.val>current.val && q.val>current.val){
                current=current.right;
            }
            else{
                return current;
            }
        }
        return null;
    }
}