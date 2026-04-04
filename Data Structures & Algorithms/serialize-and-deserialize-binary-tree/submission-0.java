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

public class Codec {

    // Encodes a tree to a single string.
    
    public String serialize(TreeNode root) {
        StringBuilder  ans=new StringBuilder();
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            TreeNode curr=qu.poll();
            if(curr==null){
                ans.append("null,");
                continue;
            }
            ans.append(curr.val);
            ans.append(",");
            qu.offer(curr.left);
            qu.offer(curr.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] w=data.split(",");
        if(w[0].equals("null"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(w[0]));
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        int i=1;
        while(!qu.isEmpty()&& i<w.length){
              TreeNode curr=qu.poll();
              if(!w[i].equals("null")){
                curr.left=new TreeNode (Integer.parseInt(w[i]));
                qu.offer(curr.left);
              }
              i++;
              if(i<w.length && !w[i].equals("null")){
                curr.right=new TreeNode (Integer.parseInt(w[i]));
                qu.offer(curr.right);
              }
              i++;
        }
        return root;
    }
}
