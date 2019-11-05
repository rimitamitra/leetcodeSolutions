/**
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
               int sum = nums[i]+nums[left]+nums[right];
            if(Math.abs(target-sum)<minDiff){
                res=sum;
                minDiff = Math.abs(target-sum);
            }
            
            if(sum<target)
                left++;
            else
                right--; 
            }   
        }
        return res;
    }
}