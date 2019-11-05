/**
*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] map = new int[128];
        int res = 0;
        char[] carr = s.toCharArray();
        int idx = 0;
        
        for(int i=0; i<carr.length; i++){
            
            while(idx<carr.length && map[carr[idx]]==0){
                map[carr[idx]]++;
                idx++;
            }
            
            res = Math.max(res, idx-i);
            map[carr[i]]--;
        }
        
       return res;
    }
}