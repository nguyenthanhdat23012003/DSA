package problem.medium.Minimum_Size_Subarray_Sum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Solution 1: Prefix sum + Brute Force
        // Time complexity: O(n^2)
        // Space Complexity: O(n)
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        
        for(int i = 1; i < n + 1; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
            if(nums[i - 1] >= target) return 1;
        }

        if(prefix[n] < target) return 0;

        int done = 2;
        while(done != 0 && done <= n){
            for(int i = n; i >= done; i--){
                if((prefix[i] - prefix[i - done]) >= target) return done;
            }

            done++;
        }

        return 0;
    }
}