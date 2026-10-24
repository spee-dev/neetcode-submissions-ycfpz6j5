class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]>qu=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qu.offer(new int[]{i,j});
                    
                }
                else if(grid[i][j]==1)fresh++;
            }
        }

        int time=0;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while(!qu.isEmpty() && fresh>0){
            int sz=qu.size();
            for(int j=0;j<sz;j++){
           int []curr=qu.poll();
           for(int i=0;i<4;i++){
            int newr=curr[0]+dr[i];
            int newc=curr[1]+dc[i];
            if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1){
                grid[newr][newc]=2;
                fresh--;
                qu.offer(new int[]{newr,newc});
            }
           }
        }
           time++;

        }
        if(fresh!=0)return -1;
        return time;

    }
}
