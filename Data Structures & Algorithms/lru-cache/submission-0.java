class LRUCache {
    class Node {
        int key,val;
        Node next,prev;
        Node (int k,int v){
            key=k;
            val=v;
            next=null;
            prev=null;
        }
    }
   Node head=new Node(-1,-1);
   Node tail=new Node (-1,-1);
   int limit;
   Map<Integer,Node>mp=new HashMap<>();
   void addNode(Node node){
    Node nextNode=head.next;
    head.next=node;
    nextNode.prev=node;

    node.next=nextNode;
    node.prev=head;
   }
   void deleteNode(Node node){
    Node oldPrev=node.prev;
    Node oldNext=node.next;
    oldPrev.next=oldNext;
    oldNext.prev=oldPrev;
   }
    public LRUCache(int capacity) {
        limit=capacity;
        head.next=tail;
    tail.prev=head;
    }
    
    public int get(int key) {
       if(!mp.containsKey(key)){
        return -1;
       }
       Node ansNode=mp.get(key);
       int ans=ansNode.val;
       deleteNode(ansNode);
       addNode(ansNode);
       return ans;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            node.val=value;
            deleteNode(node);
            addNode(node);
            return;
        }
        if(mp.size()==limit){
            Node node=tail.prev;
            mp.remove(node.key);
            deleteNode(node);
            
        }
        Node newNode=new Node(key,value);
        addNode(newNode);
        mp.put(key,newNode);
    }
}
