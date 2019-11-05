/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
**/

class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] sArr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        LinkedList<String> ll =  new LinkedList<String>();
        if(digits.equals(""))
            return ll;
        ll.add("");
        
        for(int i=0; i<digits.length();i++){
            char[] carr = sArr[digits.charAt(i) - '0'].toCharArray();
            while(ll.peek().length() == i){
                String t = ll.poll();
                for(char x: carr){
                    ll.add(t+x);
                }
            }
        }
        
        return ll;
    }
}