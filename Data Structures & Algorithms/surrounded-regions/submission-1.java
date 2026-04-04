class Solution {
    public void dfs(char[][]board,int i,int j){
        int n=board.length;
        int m =board[0].length;
        board[i][j]='S';
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        for(int t=0;t<4;t++){
            int newr=i+dr[t];
            int newc=j+dc[t];
            if(newr>=0 && newr<n && newc>=0 && newc<m && board[newr][newc]=='O'){
                dfs(board,newr,newc);
            }
        }

    }
    public void solve(char[][] board) {
        int n=board.length;
        int m =board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][m-1]=='O'){
                dfs(board,i,m-1);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O')dfs(board,0,j);
            if(board[n-1][j]=='O')dfs(board,n-1,j);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='S')board[i][j]='O';
            }
        }
    }
}
