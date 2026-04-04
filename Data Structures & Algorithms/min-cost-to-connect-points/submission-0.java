class Solution {
    class DisJoint{
        int []parrent;
        int size[];
        DisJoint(int n){
            parrent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
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
            int rootx=find(x);
            int rooty=find(y);
            if(rootx==rooty)return false;
            if(size[rootx]<size[rooty]){
                parrent[rootx]=rooty;
                size[rooty]+=size[rootx];
            }
            else{
                parrent[rooty]=rootx;
                size[rootx]+=size[rooty];
            }
            return true;
        }
        
    }
    public int minCostConnectPoints(int[][] points) {
        List<int[]>edges=new ArrayList<>();
        int n=points.length;
        int m= points[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]);
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
