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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int sz=qu.size();
            TreeNode node=null;
            for(int i=0;i<sz;i++){
                TreeNode curr=qu.poll();
                node=curr;
                if(curr.left!=null){
                    qu.offer(curr.left);
                }
                if(curr.right!=null){
                    qu.offer(curr.right);
                }
                
            }
            ans.add(node.val);
        }
        return ans;
    }
}
