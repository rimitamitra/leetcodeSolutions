/**
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
**/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 4)
            return res;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j != i+1 && nums[j] == nums[j-1] )
                    continue;
                
                int left = j+1;
                int right = nums.length-1;
                
                while(left<right){
                    
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum == target){
                        ArrayList<Integer> t = new ArrayList<>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[left]); 
                        t.add(nums[right]);
                        res.add(t);
                        left++;
                        right--;
                        while(left<right && nums[right+1]==nums[right])
                            right--;
                        while(left<right  && nums[left-1]==nums[left] )
                            left++;

                    }else if(sum <target)
                     left++;
                    else
                        right--;
                 }
            }
        }
        return res;
    }
}