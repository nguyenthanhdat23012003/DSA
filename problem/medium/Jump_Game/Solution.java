package problem.medium.Jump_Game;

class Solution {
    // // Solution 1: Dynamic Programming
    // // Time Complexity: O(n^2)
    // // Traverse from the 2nd element from the end of array 
    // // and store available index that can jump to the last 
    // // index of array to new array, if new array has the first index is 0 
    // // -> return true
    // public boolean canJump(int[] nums) {
    //     if(nums.length < 2) {
    //         return true;
    //     }
    //     int[] canJumpIdx = new int[nums.length];
    //     int canJumpIdxLength = 0;
    //     canJumpIdx[0] = nums.length - 1;
    //     for(int i = nums.length - 2; i >= 0; i--){
    //         for(int j = 0; j < nums.length; j++){
    //             if(i + nums[i] >= canJumpIdx[j] && canJumpIdx[j] != 0){
    //                 canJumpIdxLength++;
    //                 canJumpIdx[canJumpIdxLength] = i;
    //                 break;
    //             }
    //         }
    //     }

    //     for(int i = 0; i < canJumpIdxLength; i++) {
    //         if(canJumpIdx[canJumpIdxLength] == 0) return true;
    //     }

    //     return false;
    // }

    // Solution 2: Greedy
    // Time Complexity: O(n)
    // traverse from the end of array and return canJumpJdx or not -> find the minimum index that can jump to the last and compare with the first element
    public boolean canJump(int[] nums) {
        if(nums.length < 2) {
            return true;
        }
        int canJumpIdx = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= canJumpIdx){
                canJumpIdx = i;
            }
        }

        if(canJumpIdx == 0) return true;

        return false;
    }
}