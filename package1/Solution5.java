/**
*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/

class Solution5 {
    int minIdx=-1;
    int max=-1;
    public String longestPalindrome(String s) {
        
        if (s.length() < 2)
            return s;

        for (int i = 1; i < s.length(); i++) {
            findPali(s,i,i);
            findPali(s,i-1,i);
        }
        return s.substring(minIdx,minIdx+max);
    }
    
    private void findPali(String str, int left, int right) {

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        if((right-left-1) > max){
            max = right-left-1;
            minIdx = left+1;
        }
    }
}