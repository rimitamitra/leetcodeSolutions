class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<String>(wordList);
        
        if (!dic.contains(endWord)) {
            return 0;
        }
        
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        
        set1.add(beginWord);
        set2.add(endWord);
        
        return explore(dic, set1, set2, 1);
    }
    
    public int explore(Set<String> dic, Set<String> set1, Set<String> set2, int len) {
        if (set1.size() == 0) {
            return 0;
        }
        
        dic.removeAll(set1);
        dic.removeAll(set2);
        
        Set<String> nextSet = new HashSet<String>();
        
        for (String s : set1) {
            for (int i = 0; i < s.length(); i++) {
                char[] charArr = s.toCharArray();
                
                for (char c = 'a'; c <= 'z'; c++) {
                    charArr[i] = c;
                    
                    String word = new String(charArr);
                    
                    if (set2.contains(word)) {
                        return len + 1;
                    }
                    
                    if (dic.contains(word)) {
                        nextSet.add(word);
                    }
                }
            }
        }
        
        return explore(dic, set2, nextSet, len+1);
    }
}