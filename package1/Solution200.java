/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
**/

class Solution200 {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int rowL;
    int colL;
    public int numIslands(char[][] grid) {
        
        int count = 0;
        rowL = grid.length;
        if(rowL == 0)
            return count;
        colL = grid[0].length;
        
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c){
        
        if(r<0 ||r>=rowL||c<0||c>=colL||grid[r][c] == '0')
            return;
        
        grid[r][c] = '0';
        for(int[] d: dirs){
            int row = r+d[0];
            int col = c+d[1];
            dfs(grid, row, col);
        }
    }
    
}