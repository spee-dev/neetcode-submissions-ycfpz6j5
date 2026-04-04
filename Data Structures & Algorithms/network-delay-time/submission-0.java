class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //it creates Adjancy List
       List<List<int[]>>adjl=new ArrayList<>();
       for(int i=0;i<=n;i++){
        adjl.add(new ArrayList<>());
       } 
       for(int []time:times){
        int u=time[0];
        int v=time[1];
        int w=time[2];
        adjl.get(u).add(new int[]{v,w});}
        int []dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int []{0,k});
        while(!pq.isEmpty()){
            int []curr=pq.poll();
            int dis=curr[0];
            int node=curr[1];
            if(dis>dist[node])continue;
            for(int []it:adjl.get(node)){
                int neighbour=it[0];
                int wt=it[1];
                if(dist[node]+wt<dist[neighbour]){
                    dist[neighbour]=dist[node]+wt;
                    pq.offer(new int[]{dist[neighbour],neighbour});
                }
            }
        }
        int maxdelay=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            maxdelay=Math.max(maxdelay,dist[i]);
        }
       return maxdelay;
    
}
}
