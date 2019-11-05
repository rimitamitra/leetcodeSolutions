/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
**/

class Solution {
    public boolean exist(char[][] board, String word) {
        
        boolean res = false;
        if(board.length < 1)
            return res;
        if(board.length * board[0].length < word.length())
            return res;
      
        outer:
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                res = search(board, i, j, word, 0);
                if(res)
                    break outer;
            }
        }
        
        return res;
    }
    
    private boolean search(char[][] board, int row, int col, String word, int counter){
        
        
        if(counter==word.length())
            return true;
        
        //All the checks.
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col]!=word.charAt(counter))
            return false;
        
        char temp = board[row][col];
        board[row][col] = '#';
        
        //north
        if (search(board, row-1, col, word, counter+1)) {
            return true;
        }
        
        //south
        if (search(board, row+1, col, word, counter+1)) {
            return true;
        }
        
        //east
        if (search(board, row, col-1, word, counter+1)) {
            return true;
        }
        
        //west
        if (search(board, row, col+1, word, counter+1)) {
            return true;
        }
        
        board[row][col] = temp;
        return false;
    }
}