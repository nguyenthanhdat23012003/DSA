package problem.medium.Rotate_Array;

class Solution {
    // // Solution 1
    // // Rotate the array by 1 steps in k times
    // // Time Complexity: O(kn)
    // public void rotate(int[] nums, int k) { 
    //     k = k % nums.length;      
    //     while(k > 0) {
    //         int save = nums[nums.length - 1];
    //         for (int i = nums.length - 1; i > 0; i--) {
    //             nums[i] = nums[i-1];
    //         }
    //         nums[0] = save;
    //         k--;
    //     }
    // }

    // Solution 2
    // Reverse all the array, after that reverse partical of the array
    // Time complexity: O(n)
    public void rotate(int[] nums, int k) {
        k = k % nums.length; 
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // // Solution 3
    // // To be update ...
    // public void rotate(int[] nums, int k) {
    //     rotateRecursive(nums, 0, nums.length - 1, k);
    // }

    // public void rotateRecursive(int[] nums, int start, int end, int k) {
    //     int length = end - start + 1;
    //     if(k == length/2) {
    //         for(int i = start; i < start + k; i++){
    //             swap(nums, i, i + k);
    //         }
    //     } else if (k < length/2) {
    //         for(int i = start; i < start + k; i++){
    //             swap(nums, i, i + length - k);
    //         }
    //         rotateRecursive(nums, start + k, end, k);
    //     } else {
    //         reverse(nums, start, end);
    //         rotateRecursive(nums, start, end, k);
    //     }
    // }

    // public void reverse(int[] nums, int start, int end) {
    //     while(start < end){
    //         int temp = nums[start];
    //         nums[start] = nums[end];
    //         nums[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }

    // public void swap(int[] nums, int a, int b) {
    //     int temp = nums[a];
    //     nums[a] = nums[b];
    //     nums[b] = temp;
    // }
}