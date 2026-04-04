class Solution {
    int dfs(int[][]grid,int row,int col,int[][]vis){
        vis[row][col]=1;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        int cnt=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int newr=row+dr[i];
            int newc=col+dc[i];
           if(newr>=0 && newr<n && newc>=0 &&newc<m &&grid[newr][newc]==1 && vis[newr][newc]==0){
           
            cnt+=dfs(grid,newr,newc,vis);
           }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        int maxf=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 &&vis[i][j]==0){
                    maxf=Math.max(maxf,dfs(grid,i,j,vis));
                }
            }
        }
        return maxf;
    }
}
