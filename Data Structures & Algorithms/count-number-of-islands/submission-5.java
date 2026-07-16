class Solution {
    void dfs(int row,int col,char[][]grid){
        grid[row][col]='0';
        int n=grid.length;
        int m=grid[0].length;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        for(int i=0;i<4;i++){
            int newr=dr[i]+row;
            int newc=dc[i]+col;
            if(newr>=0 && newr<n && newc>=0 && newc<m && grid[newr][newc]=='1'){
                dfs(newr,newc,grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}
