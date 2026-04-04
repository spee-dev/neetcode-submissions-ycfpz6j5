class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
               ArrayList<ArrayList<int[]>>adjl=new ArrayList<>();
               for(int i=0;i<n;i++){
                  adjl.add(new ArrayList<>());
               }
               for(int []ed:flights){
                 int u=ed[0];
                 int v=ed[1];
                 int pr=ed[2];
                 adjl.get(u).add(new int[]{v,pr});
               }

               int cost[]=new int[n];
               Arrays.fill(cost,Integer.MAX_VALUE);
               cost[src]=0;

               Queue<int[]>qu=new LinkedList<>();
               qu.add(new int[]{0,src,0});

               while(!qu.isEmpty()){
                      int curr[]=qu.poll();
                      int c=curr[0];
                      int node=curr[1];
                      int st=curr[2];
                      if(st>k)continue;
                      for(int []it:adjl.get(node)){
                        int nei=it[0];
                        int w=it[1];
                        if(c+w<cost[nei]){
                            cost[nei]=c+w;
                            qu.add(new int[]{cost[nei],nei,st+1});
                        }
                      }
               }
               return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }
}
