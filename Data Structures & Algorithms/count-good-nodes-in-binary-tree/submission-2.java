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
    // public int dfs(TreeNode root,int max_val){
    //     if(root==null)return 0;
    //     int res=(root.val>=max_val)?1:0;
    //     max_val=Math.max(max_val,root.val);
    //     res+=dfs(root.left,max_val);
    //     res+=dfs(root.right,max_val);
    //     return res;
    // }
    public int goodNodes(TreeNode root) {
    //    
    Queue<Pair<TreeNode,Integer>>qu=new LinkedList<>();
    qu.offer(new Pair<>(root,root.val));
    int count =0;
    while(!qu.isEmpty()){
        Pair<TreeNode, Integer>curr=qu.poll();
        TreeNode node=curr.getKey();
        int max_s=curr.getValue();
        if(node.val>=max_s)count++;
        int newm=Math.max(node.val,max_s);
        if(node.left!=null)qu.offer(new Pair<>(node.left,newm));
        if(node.right!=null)qu.offer(new Pair<>(node.right,newm));
    }
    return count;

    }
}
