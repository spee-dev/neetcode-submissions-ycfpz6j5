class Solution {
    boolean bfs(ArrayList<ArrayList<Integer>>adjl,int node, boolean[]vis){
        Queue<int[]>qu=new LinkedList<>();
        qu.offer(new int[]{node,-1});
        vis[node]=true;
       while(!qu.isEmpty()){
        int[] curr=qu.poll();
        int node1=curr[0];
        int parrent=curr[1];
          for(Integer it:adjl.get(node1)){
            if(vis[it]==false){
               qu.offer(new int[]{it,node1});
               vis[it]=true; 
            }
            else if(parrent!=it){
                return true;
            }
          }
       }
       return false;
    }

    public boolean validTree(int n, int[][] edges) {
       
       ArrayList<ArrayList<Integer>>adjl=new ArrayList<ArrayList<Integer>>();
       for(int i=0;i<n;i++){
           adjl.add(new ArrayList<>());
       }
       for(int [] ed:edges){
        adjl.get(ed[0]).add(ed[1]);
        adjl.get(ed[1]).add(ed[0]);
       }
       if(edges.length!=n-1)return false;
       boolean[]vis=new boolean[n];
       if(bfs(adjl,0,vis)){
        return false;
       }
       for(int i=0;i<n;i++){
        if(!vis[i])return false;
       }
       return true;
    }
}
