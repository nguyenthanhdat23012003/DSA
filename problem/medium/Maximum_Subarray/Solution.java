package problem.medium.Maximum_Subarray;

class Solution {
    // // Solution 1
    // // Dynamic Programming
    // public int maxSubArray(int[] nums) {
    //     int maxSum = nums[0];
    //     int currentSum = nums[0];
    //     for(int i = 1; i < nums.length; i++) {
    //         currentSum = max(currentSum + nums[i], nums[i]);
    //         maxSum = max(maxSum, currentSum);
    //     }

    //     return maxSum;
    // }

    // public int max(int a, int b) {
    //     return (a > b) ? a : b;
    // }

    // Solution 2
    // Divide and conquer
    public int maxSubArray(int[] nums) {
        return maxSubArrayRecursive(nums, 0, nums.length - 1);
    }

    public int maxSubArrayRecursive(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (start + end) / 2;

        int leftMax = maxSubArrayRecursive(nums, start, mid);
        int rightMax = maxSubArrayRecursive(nums, mid + 1, end);
        int crossMax = maxSubArrayThroughMid(nums, start, end);

        return max(max(leftMax, rightMax), crossMax);
    }

    public int maxSubArrayThroughMid(int[] nums, int start, int end) {
        int mid = (start + end) / 2;

        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= start; i--) {
            currentSum += nums[i];
            leftSum = max(leftSum, currentSum);
        }

        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= end; i++) {
            currentSum += nums[i];
            rightSum = max(rightSum, currentSum);
        }

        return leftSum + rightSum;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

}