package problem.medium.Jump_Game_2;

class Solution {
    // // Solution 1
    // // Dynamic Programming
    // public int jump(int[] nums) {
    //     if(nums.length == 1) return 0;
    //     int[] minimumJump = new int[nums.length];
    //     minimumJump[nums.length - 1] = 1;
    //     for(int i = nums.length - 2; i >= 0; i--) {
    //         for(int j = nums.length - 2; j >=i; j--){
    //             if(nums[i] + i >= nums.length - 1){
    //                 minimumJump[i] = 1;
    //             } else if (nums[i] + i >= j && minimumJump[j] != 0) {
    //                 if (minimumJump[i] != 0) {
    //                     minimumJump[i] = min(minimumJump[i], minimumJump[j] + 1);
    //                 } else {
    //                     minimumJump[i]  = minimumJump[j] + 1;
    //                 }
    //             }
    //         }
    //     }

    //     return minimumJump[0];
    // }

    // public int min(int a, int b){
    //     return (a < b) ? a : b;
    // }

    // Solution 2
    // Greedy
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int currentIdx = 0;
        int jump = 0;
        int maxIdxCanJump = 0;
        for(int i = 0; i < nums.length; i++){
            maxIdxCanJump = max(maxIdxCanJump, nums[i] + i);
            if(i == currentIdx) {
                jump++;
                currentIdx = maxIdxCanJump;
                if(currentIdx >= nums.length - 1) break;
            }
        }

        return jump;
    }

    public int max(int a, int b){
        return (a > b) ? a : b;
    }
}