class Disjoint{
    int parrent[];
    int size[];
    Disjoint(int n){
        parrent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parrent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parrent[x]!=x){
            parrent[x]=find(parrent[x]);
        }
        return parrent[x];
    }
    boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu==pv)return true;
        if(size[pu]<size[pv]){
            parrent[pu]=pv;
            size[pv]+=size[pu];
        }
        else{
            parrent[pv]=pu;
            size[pu]+=size[pv];
        }
        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Disjoint dsu=new Disjoint(edges.length);
        for(int []ed:edges){
            int u=ed[0];
            int v=ed[1];
            if(dsu.union(u,v)) return new int[]{u,v};
             
        }
        return new int[0];
    }
}
