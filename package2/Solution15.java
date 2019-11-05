/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
**/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length == 0)
            return res;
        
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            
            int left = i+1;
            int right = nums.length - 1;
            int sum = 0 - nums[i];
            while(left < right){
                if(nums[left]+nums[right] == sum){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    
                    while(left<right && nums[left] == nums[left+1])
                        left++;
                    while(left<right && nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }else if(nums[left]+nums[right] > sum){
                    right--;
                }else{
                    left++;
                }
            }
        }
        
        return res;
    }
}