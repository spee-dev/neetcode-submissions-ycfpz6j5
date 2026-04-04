class Solution {
    public int orangesRotting(int[][] grid) {
        int freshc=0;
        Queue<int[]>qu=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qu.offer(new int[]{i,j});
                    vis[i][j]=2;

                }
                else if(grid[i][j]==1){
                    freshc++;
                }
            }
        }
        int t=0;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while(!qu.isEmpty() && freshc>0){
            int sz=qu.size();
            for(int i=0;i<sz;i++){
                int []curr=qu.poll();
                for(int j=0;j<4;j++){
                    int newr=curr[0]+dr[j];
                    int newc=curr[1]+dc[j];
                    if(newr>=0 && newr<n &&newc>=0&&newc<m && grid[newr][newc]==1 &&vis[newr][newc]!=2){
                        qu.offer(new int[]{newr,newc});
                        vis[newr][newc]=2;
                        freshc--;
                    }
                }
            }
            t++;
        }
        return freshc==0?t:-1;
    }
}
