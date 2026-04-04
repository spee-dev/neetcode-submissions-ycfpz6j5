class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>>adjl=new ArrayList<>();
       
        for(int i=0;i<n;i++){
            adjl.add(new ArrayList<>());
        }
        for(int []fl:flights){
            int u=fl[0];
            int v=fl[1];
            int cost=fl[2];
            adjl.get(u).add(new int[]{v,cost});
        }

        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]>qu=new LinkedList<>();
        
        qu.offer(new int[]{0,src,0});
        while(!qu.isEmpty()){
            int curr[]=qu.poll();
            int cs=curr[0];
            int node=curr[1];
            int stop=curr[2];
            if(stop>k)continue;
            for(int []it:adjl.get(node)){
                int neighbour=it[0];
                int pr=it[1];
                if(pr+cs<dist[neighbour]){
                    dist[neighbour]=pr+cs;
                    qu.offer(new int[]{dist[neighbour],neighbour,stop+1});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
