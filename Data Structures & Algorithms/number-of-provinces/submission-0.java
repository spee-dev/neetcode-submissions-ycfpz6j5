class Solution {
    void dfs(int city,int[][]isConnected,boolean[] visit){
        visit[city]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[city][i]==1 && visit[i]==false){
                dfs(i,isConnected,visit);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int v=isConnected.length;
        boolean[] vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                ans++;
                dfs(i,isConnected,vis);
            }
        }
        return ans;
    }
}