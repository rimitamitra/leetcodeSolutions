/**
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
**/

class Solution130 {
    
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int rowMax;
    int colMax;
    public void solve(char[][] board) {
        
        if(board == null || board.length ==0)
            return;
        rowMax = board.length;
        colMax = board[0].length;
        
        for(int i=0;i<rowMax;i++){
            if(board[i][0] == 'O')
                dfs(board, i, 0);
        }
        
        for(int i=0;i<rowMax;i++){
            if(board[i][colMax-1] == 'O')
                dfs(board, i, colMax-1);
        }
        
        for(int j=0;j<colMax;j++){
            if(board[0][j] == 'O')
                dfs(board,0,j);
        }
        
        for(int j=0;j<colMax;j++){
            if(board[rowMax-1][j] == 'O')
                dfs(board,rowMax-1,j);
        }
        
        for(int i=0;i<rowMax;i++){
            for(int j=0; j<colMax;j++){
                if(board[i][j]=='X')
                    continue;
                else if(board[i][j]=='#')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c){
        
        if(r<0||r>=rowMax||c<0||c>=colMax|| board[r][c] != 'O')
            return;
        
        board[r][c] = '#';
        for(int[] d: dirs){
            int row = r+d[0];
            int col = c+d[1];
            dfs(board, row, col);
        }
    }
}