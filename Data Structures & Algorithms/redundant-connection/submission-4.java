class DisJoint{
    int []parrent;
    int []rank;
    DisJoint(int n){
        parrent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parrent[i]=i;
            rank[i]=i;
        }
    }
    int find(int x){
        if(parrent[x]!=x){
            parrent[x]=find(parrent[x]);

        }
        return parrent[x]; 
    }
    boolean union(int x,int y){
        int rootx=find(x);
        int rooty=find(y);
        if(rootx==rooty)return true;
        if(rank[rootx]<rank[rooty]){
            parrent[rootx]=rooty;
        }
        else if(rank[rooty]<rootx){
            parrent[rooty]=rootx;
        }
        else{
            parrent[rootx]=rooty;
            rank[rooty]++;
        }
        return false;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisJoint dsu=new DisJoint(n);
        for(int []ed:edges){
            int u=ed[0];
            int v=ed[1];
            if(dsu.union(u,v)){
                return new int[]{u,v};
            }
        }
        return new int[0];
    }
}
