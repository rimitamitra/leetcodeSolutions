/**
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
**/

class Solution {
    public int myAtoi(String str) {
        
        str = str.trim();
        if(str.length()==0)
            return 0;
        
        boolean signed = (str.charAt(0)=='-' || str.charAt(0)=='+') ? true:false;
        boolean neg = false;
        
        if(signed){
            neg = (str.charAt(0)=='-') ? true : false;
            str = str.substring(1);
        }
       
        int count=0;
        double num = 0;
        
        while(count<str.length()){
            if(!Character.isDigit(str.charAt(count)))
                break;
            
            num = num*10 + str.charAt(count) - '0';
            count++;
        }
        
        if(neg)
            num *= (-1);
        
        
        if(num > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(num < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) num;
    }
}