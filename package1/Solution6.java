/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
**/

class Solution {
    public String convert(String s, int numRows) {
       
        if (s.length() < 2)
            return s;
        if(numRows < 2)
            return s;
        
        StringBuffer[] sb = new StringBuffer[numRows];

        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuffer();

        int magic = 2 * numRows - 2;
        int idx = 0;
        while (idx < s.length()) {
            for (int i = 0; i <= magic / 2 && idx < s.length(); i++) {
                StringBuffer sbf = sb[idx % magic];
                sbf.append(s.charAt(idx++));
            }

            for (int j = (1 + magic / 2); j < magic && idx < s.length(); j++) {
                StringBuffer sbf = sb[magic - (idx % magic)];
                sbf.append(s.charAt(idx++));
            }
        }

        String res = "";

        for (int i = 0; i < numRows; i++) {
            res = res + sb[i].toString();
        }

        return res;
    }
}