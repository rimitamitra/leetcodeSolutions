/**

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9

**/


class Solution1 {
    
    public int[] twoSum(int[] num, int target) {
         Map<Integer, Integer> hm = new HashMap<>();
        int[] resp = new int[2];

        for(int i=0; i<num.length; i++){
            int x = target - num[i];

            if(hm.containsKey(x)){
                resp[0] = i;
                resp[1] = hm.get(x);
                break;
            }else{
                hm.put(num[i], i);
            }
        }

        return resp;
    }
}