/**
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
**/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for(String w: words){
            int val = dict.getOrDefault(w, 0);
            dict.put(w,val+1);
        }
            
        int wordNum = words.length;
        if(wordNum == 0)
            return res;
        int wordLen = words[0].length();
        
        for(int i=0; i<s.length()-wordNum*wordLen+1; i++){
            Map<String, Integer> seen = new HashMap<>();
            int num = 0;
            
            while(num < wordNum){
               String temp = s.substring(i+num*wordLen, i+(num+1)*wordLen);
            
                if(dict.containsKey(temp)){
                    int val = seen.getOrDefault(temp, 0);
                    seen.put(temp,val+1);
                    
                    if(seen.get(temp) <= dict.get(temp)){
                        num++;
                    }else
                        break;
                }else
                    break;
            }
            
            if(num == wordNum)
                res.add(i);
        }
        
        return res;
    }
}