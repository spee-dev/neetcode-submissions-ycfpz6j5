class Disjoint{
    int []parrent;
    int []size;
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
    boolean union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return true;
        if(size[px]<size[py]){
            parrent[px]=py;
            size[py]+=size[px];
        }
        else{
            parrent[py]=px;
            size[px]+=size[py];
        }
        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        Disjoint dsu=new Disjoint(n);
        for(int ed[]:edges){
            if(dsu.union(ed[0],ed[1])){
                return new int[]{ed[0],ed[1]};
            }
        }
        return new int[0];
    }
}
