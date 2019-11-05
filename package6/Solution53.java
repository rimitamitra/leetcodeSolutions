/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*/

class Solution53 {
    public int maxSubArray(int[] nums) {
     
    if(nums.length == 0)
        return 0;
    
    int prevSum, maxSum;
    prevSum = maxSum = nums[0];
    
    for(int i =1; i<nums.length; i++){
        prevSum = Math.max(prevSum+nums[i], nums[i]);
        maxSum = Math.max(prevSum, maxSum);
    }
        
     
        return maxSum;
}
   
}