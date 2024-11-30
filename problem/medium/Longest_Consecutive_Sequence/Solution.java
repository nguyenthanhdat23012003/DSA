package problem.medium.Longest_Consecutive_Sequence;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> store = new HashSet<>();
        int maxLength = 0;

        for(int i = 0; i < nums.length; i++){
            store.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if(!store.contains(nums[i] - 1)){
                int check = nums[i];
                int currentMax = 1;
                while(store.contains(check + 1)){
                    currentMax++;
                    check++;
                }
                if(currentMax > maxLength) maxLength = currentMax;
            }
        }

        return maxLength;
    }
}