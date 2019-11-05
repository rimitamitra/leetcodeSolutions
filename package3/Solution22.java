/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        if(n==0)
            return res;
        
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, String curr, int open, int close, int n){
        
        if(curr.length()==n*2)
            res.add(curr);
        
        if(open<n){
            backtrack(res, curr+'(', open+1, close, n);
        }
        
        if(close<open)
            backtrack(res, curr+')', open, close+1, n);
    }
}