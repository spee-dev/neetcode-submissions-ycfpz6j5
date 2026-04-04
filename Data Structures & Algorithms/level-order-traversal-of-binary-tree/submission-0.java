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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            TreeNode node;
            List<Integer>a=new ArrayList<>();
            int siz=qu.size();
            for(int i=0;i<siz;i++){
                 node=qu.poll();
                a.add(node.val);
                 if(node.left!=null)qu.add(node.left);
            if(node.right!=null)qu.add(node.right);
            }
           
            ans.add(a);
        }
        return ans;
        
    }
}
