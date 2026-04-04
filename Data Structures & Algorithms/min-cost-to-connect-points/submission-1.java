class DisJoint{
    int []parrent;
    int []size;
    DisJoint(int n){
         parrent=new int[n];
         size=new int[n];
         for(int i=0;i<n;i++){
            parrent[i]=i;
            size[i]=0;
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
        if(px==py)return false;

        if(size[px]<size[py]){
            parrent[px]=py;
        }
        else if(size[py]<size[px]){
            parrent[py]=px;
        }
        else{
            parrent[px]=py;
            size[py]++;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
       List<int[]>edges=new ArrayList<>();
       int n=points.length;
       int m=points[0].length;
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            edges.add(new int[]{i,j,dist});
        }
       } 
       edges.sort(Comparator.comparingInt(a->a[2]));
       DisJoint ds=new DisJoint(n);
       int minCost=0;
       int edC=0;
       for(int []ed:edges){
        if(ds.union(ed[0],ed[1])){
            minCost+=ed[2];
            edC++;
            if(edC==n-1)break;
        }
       }
       return minCost;
    }
}
