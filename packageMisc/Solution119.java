/**
Pascals triangle
Input: 3
Output: [1,3,3,1]
**/

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        
        int numRows = rowIndex + 1;
        int[][] grid = new int[numRows][numRows];
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<numRows; i++){
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    grid[i][j] = 1;
                }else{
                    grid[i][j] = grid[i-1][j-1] + grid[i-1][j];
                }
                if(i == rowIndex)
                    res.add(grid[i][j]);
            }
        }
        
        return res;
    }
}