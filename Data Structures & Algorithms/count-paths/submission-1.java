class Solution {
    int dfs(int m,int n,int i,int j,int [][]dp){
        if(i==n-1 && j==m-1)return 1;
        if(i>=n ||j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int down=dfs(m,n,i+1,j,dp);
        int right=dfs(m,n,i,j+1,dp);
        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
        int [][]dp=new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(m,n,0,0,dp);
    }
}
