class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]>qu=new LinkedList<>();
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
             if(grid[i][j]==0)
               qu.offer(new int[]{i,j});
           }
        }
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        int dis=0;
        while(!qu.isEmpty()){
            dis++;
            int sz=qu.size();
            for(int i=0;i<sz;i++){
                int []curr=qu.poll();
                for(int j=0;j<4;j++){
                    int newr=curr[0]+dr[j];
                    int newc=curr[1]+dc[j];
                    if(newr>=0 && newr<n && newc>=0 &&newc<m && grid[newr][newc]==Integer.MAX_VALUE){
                        grid[newr][newc]=dis;
                        qu.offer(new int[]{newr,newc});
                    }
                }
            }
           
        }
        
    }
}
