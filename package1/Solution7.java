/**
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
**/

class Solution {
    public int reverse(int x) {
        
        long res = 0;
        long _X = Math.abs((long) x);
        
        while(_X>0){
            res = res*10 + _X%10;
            _X /= 10;
        }
        
        if(res>Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        else{
            return x<0? (int)res*-1: (int)res;
        }
    }
}