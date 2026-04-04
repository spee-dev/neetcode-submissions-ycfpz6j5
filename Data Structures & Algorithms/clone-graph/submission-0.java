/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node UtilC(Node node, Map<Node,Node>mp){
        Node newNode=new Node(node.val);
        mp.put(node,newNode);
        for(Node neigh:node.neighbors){
            if(mp.containsKey(neigh)){
                newNode.neighbors.add(mp.get(neigh));
            }
            else{
                newNode.neighbors.add(UtilC(neigh,mp));
            }
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if(node ==null)return null;
        Map<Node,Node>mp=new HashMap<>();
        return UtilC(node,mp);
    }
}