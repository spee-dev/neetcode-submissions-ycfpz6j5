class Solution {
    void dfs(int row,int col, char[][]grid){
        grid[row][col]='0';
        int n=grid.length;
        int m=grid[0].length;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newr=row+dr[i];
            int newc=col+dc[i];
            if(newr>=0 && newr<n &&newc>=0 &&newc<m && grid[newr][newc]=='1'){
                dfs(newr,newc,grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
}
