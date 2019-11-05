/**
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
*/

class Solution42 {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int totalWater = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        maxLeft[0] = height[0];
        for (int i = 1; i < height.length; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--)
            maxRight[i] = Math.max(maxRight[i+1], height[i]);

        for (int i = 1; i < height.length - 1; i++) {
            totalWater += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        
        return totalWater;
    }
}