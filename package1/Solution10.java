/**
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
**/

class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean[][] t = new boolean[s.length()+1][p.length()+1];
        
        t[0][0] = true;
        
        for(int i=1; i<t[0].length; i++){
            if(p.charAt(i-1) == '*')
                t[0][i] = t[0][i-2];
        }
        
        for(int i=1; i<t.length; i++){
            for(int j=1; j<t[0].length; j++){
                
                if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i-1))
                    t[i][j] = t[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    t[i][j] = t[i][j-2]; // this is for zero occurance
                    if(p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2))
                        t[i][j] = t[i][j] | t[i-1][j];
                }else
                 t[i][j] = false;
            }
        }
        
        return t[s.length()][p.length()];
    }
}