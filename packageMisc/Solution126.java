/*Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*/


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> dict = new HashSet<>(wordList);
        
        if(!dict.contains(endWord))
            return 0;
        
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        
        return bfs(dict, set, endWord, 1);
    }
    
    private int bfs(Set<String> dict, Set<String> currSet, String endWord, int len){
        
        if(currset.size()==0)
            return 0;
        
        dict.remove(currset);
        Set<String> newSet = new HashSet<>();
        
        for(String s: currSet){
            char[] carr = s.toCharArray();
            for(int i=0; i<carr.length; i++){
                for(char c='a'; c<='z'; c++){
                    carr[i] = c;
                    
                    String newWord = new String(carr);
                    if(newWord.equals(endWord))
                        return len+1;
                    
                    if(dict.conatins)
                        newSet.add(newWord);
                }
            }
        }
        
        return bfs(dict, newSet, endWord, len+1);
    }
}