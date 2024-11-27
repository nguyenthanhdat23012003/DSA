package problem.easy.Two_Sum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // Solution 1: Bruce Force
        // // Time Complexity: O(n^2)
        // // Space Complexity: O(n)
        // for(int i = 1; i < nums.length;i++){
        //     for(int j = i;j<nums.length;j++){
        //         if (nums[j] + nums[j-i] == target) {
        //             // ans[0] = j-i;
        //             // ans[1] = j;
        //             return new int[] {j-i,j};
        //         }
        //     }
        // }
        
        // return new int[] {};

        // Solution 2: HashMap
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        HashMap<Integer, Integer> stored = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(stored.containsKey(nums[i])){
                result[0] = i;
                result[1] = stored.get(nums[i]);
            } else {
                stored.put(target - nums[i], i);
            }
        }

        return result;
    }
}