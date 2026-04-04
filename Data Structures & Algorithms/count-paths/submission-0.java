class Solution {
    int dfs(int m,int n,int i,int j){
        if(i==n-1 && j==m-1)return 1;
        if(i>=n ||j>=m)return 0;
        int down=dfs(m,n,i+1,j);
        int right=dfs(m,n,i,j+1);
        return down+right;
    }
    public int uniquePaths(int m, int n) {
        return dfs(m,n,0,0);
    }
}
