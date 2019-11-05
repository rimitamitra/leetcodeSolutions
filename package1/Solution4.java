/**
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
**/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        double res = 0.0;
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int left = 0;
        int right = len1;
        
        while(left<= right){
            //partion1+partition2 = (len1+len2+1)/2
            int part1 = (left+right)/2;
            int part2 = (len1+len2+1)/2 - part1;
            
            //if partition is 0, that means no numbers are left on the left.
            int maxLeft1 = (part1==0)? Integer.MIN_VALUE : nums1[part1-1];
            int maxLeft2 = (part2==0)? Integer.MIN_VALUE : nums2[part2-1];
            
            
            int minRight1 = (part1==len1)? Integer.MAX_VALUE : nums1[part1];
            int minRight2 = (part2==len2)? Integer.MAX_VALUE : nums2[part2];
            
            if(maxLeft1<=minRight2 && maxLeft2<=minRight1){
                if((len1+len2)%2==0)
                    res = (double) (Math.max(maxLeft1,maxLeft2) + Math.min(minRight1,minRight2))/2;
                else
                    res = (double) Math.max(maxLeft1,maxLeft2);
                break;
            }else if(maxLeft1 > minRight2){
                right = part1-1;
            }else{
                left = part1+1;
            }
        }
        
        return res;
    }
}