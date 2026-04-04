class Solution {
    int dfs(int [][]grid,int row,int col,boolean[][]visit){
        visit[row][col]=true;
        int count=1;
        int n=grid.length;
        int m=grid[0].length;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newr=row+dr[i];
            int newc=col+dc[i];
            if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]==1 && visit[newr][newc]==false){
                count+=dfs(grid,newr,newc,visit);
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max_f=0;
        boolean [][]visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && visit[i][j]!=true){
                    max_f=Math.max(max_f,dfs(grid,i,j,visit));
                }
            }
        }
        return max_f;
    }
}
