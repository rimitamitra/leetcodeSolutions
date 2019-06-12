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

class Solution22 {
    public List<String> generateParenthesis(int n) {
       
        ArrayList<String> res = new ArrayList<>();
        if(n<1)
            return res;
        
        String curr = "";
        generation(res, curr, n, 0);
        return res;
        
    }
    
    public static String generation(List<String> res, String curr, int opening, int closing){
        
        if(opening == 0){
            while(closing > 0){
                curr += ')';
                closing--;
            }
            res.add(curr); 
            return curr;
        }else if(closing == 0)
            return generation(res, curr+'(', opening-1, closing+1);
        
        return generation(res, curr+'(', opening-1, closing+1) + generation(res, curr+')',opening, closing-1);
    }
}