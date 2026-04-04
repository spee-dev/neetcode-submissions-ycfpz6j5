class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int [][]dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int []dir={-1,0,1,0};
        int []dc={0,1,0,-1};
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int currE=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(currE>dist[r][c])continue;
            
            for(int i=0;i<4;i++){
                int newr=r+dir[i];
                int newc=c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<m){
                    int stepEffort=Math.abs(heights[newr][newc]-heights[r][c]);
                    int newe=Math.max(stepEffort,currE);
                    if(newe<dist[newr][newc]){
                        dist[newr][newc]=newe;
                        pq.offer(new int[]{newe,newr,newc});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}