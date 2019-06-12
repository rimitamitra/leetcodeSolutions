/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
**/

class Solution32 {
    public int longestValidParentheses(String s) {
        
        int res = 0;
        if(s.length()<=1)
            return res;
        int counter = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        while(counter < s.length()){
            if(s.charAt(counter)=='(')
                st.push(counter);
            else{
                st.pop();
                if(st.empty())
                    st.push(counter);
                else
                    res = Math.max(res, counter-st.peek());
            }
            counter++;
        }
        
        return res;
    }
}