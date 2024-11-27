package problem.easy.Two_Sum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Solution 1: Bruce Force
        // Time Complexity: O(n^2)
        // Space Complexity: O(n)
        for(int i = 1; i < nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if (nums[j] + nums[j-i] == target) {
                    // ans[0] = j-i;
                    // ans[1] = j;
                    return new int[] {j-i,j};
                }
            }
        }
        
        return new int[] {};
    }
}