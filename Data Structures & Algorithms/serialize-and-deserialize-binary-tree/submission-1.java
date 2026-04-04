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
         Queue<TreeNode>qu=new LinkedList<>();
         qu.offer(root);
         StringBuilder stb=new StringBuilder();
         while(!qu.isEmpty()){
             TreeNode curr=qu.poll();
             if(curr==null){
                stb.append("null,");
                continue;
             }
             stb.append(curr.val);
             stb.append(",");
             qu.offer(curr.left);
             qu.offer(curr.right);
         } 
         return stb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String []ele=data.split(",");
        if(ele[0].equals("null"))return null;
        TreeNode root=new TreeNode(Integer.parseInt(ele[0]));
        int i=1;
        Queue<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty() && i<ele.length){
            TreeNode curr=qu.poll();
            if(!ele[i].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(ele[i]));
                qu.offer(curr.left);
            }
            i++;
            if(i<ele.length && !ele[i].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(ele[i]));
                qu.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
