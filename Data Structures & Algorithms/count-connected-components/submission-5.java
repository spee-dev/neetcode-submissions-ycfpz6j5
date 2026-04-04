class Solution {
    public void dfs(ArrayList<ArrayList<Integer>>adj,boolean[] vis,int node){
       vis[node]=true;
       for(Integer it:adj.get(node)){
        if(vis[it]==false){
            dfs(adj,vis,it);
        }
       }
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adjls=new ArrayList<ArrayList<Integer>>();
        boolean [] vis=new boolean[n];
        for(int i=0;i<n;i++){
            adjls.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adjls.get(edge[0]).add(edge[1]);
            adjls.get(edge[1]).add(edge[0]);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
              if(!vis[i]){
                dfs(adjls,vis,i);
                cnt++;
              }
        }
        return cnt; 
    }
}
