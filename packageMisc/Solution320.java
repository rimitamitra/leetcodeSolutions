Write a function to generate the generalized abbreviations of a word. 

Note: The order of the output does not matter.

Example:

Input: "word"
Output:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]




public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<>();
        backtrack(res,word, new StringBuilder(), 0, 0);
        return res;
    }
    
    private void backtrack(List<List<String>> res, String word, StringBuilder sb, int ctr, int num){
        
        int len = sb.length();
        if(ctr == word.length()){
            if(num!=0)
                sb.append(num);
            res.add(sb.toString());
        }else{
            backtrack(res, word, sb, ctr+1, num+1);
        
            if(num!=0)
                sb.append(num);
            sb.append(word.charAt(ctr));
            backtrack(res, word, sb, ctr+1, 0);
        }
        sb.setLength(len);
    }
}
