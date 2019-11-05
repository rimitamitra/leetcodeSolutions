/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/

class Solution20 {
    public boolean isValid(String s) {
    if(s.length()<1)
        return true;
        
    if(s.length()<2)
        return false;
    boolean res = true;
    Stack<Character> st = new Stack<Character>();
        st.push('a');

    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c=='{' || c=='[' || c=='('){
            st.push(c);
        }else{
            char t = st.pop();
            switch(c){
                case '}':{
                    if(t!='{')
                        res = false;
                        break;
                    }
                    case ']':{
                    if(t!='[')
                        res = false;
                        break;
                    }
                    case ')':{
                    if(t!='(')
                        res = false;
                        break;
                    }
                    
                }
                if(!res)
                    break;
            }    
        }
            
        return st.size()>1?false:res;
    }
}