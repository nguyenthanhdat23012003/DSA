package problem.medium.Minimum_Size_Subarray_Sum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // // Solution 1: Prefix sum + Brute Force
        // // Time complexity: O(n^2)
        // // Space Complexity: O(n)
        // int n = nums.length;
        // int[] prefix = new int[n + 1];
        // prefix[0] = 0;
        
        // for(int i = 1; i < n + 1; i++){
        //     prefix[i] = prefix[i - 1] + nums[i - 1];
        //     if(nums[i - 1] >= target) return 1;
        // }

        // if(prefix[n] < target) return 0;

        // int done = 2;
        // while(done != 0 && done <= n){
        //     for(int i = n; i >= done; i--){
        //         if((prefix[i] - prefix[i - done]) >= target) return done;
        //     }

        //     done++;
        // }

        // return 0;

        // Solution 2: Dynamic-size Sliding Window
        // Time complexity: O(n)
        // Space Complexity: O(1)
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum+=nums[i];
            if(nums[i] >= target) return 1;
        }

        if(sum < target) return 0;
        if(sum == target) return n;

        int left = 0;
        int right = 0;
        int step = n;
        int subSum = nums[0];
        while(right < n){
            if(subSum >= target) {
                step = Math.min(step, right - left + 1);
                subSum = subSum - nums[left];
                left++;
            } else {
                right++;
                if(right < n) subSum+=nums[right];
            }
        }

        return step;
    }
}