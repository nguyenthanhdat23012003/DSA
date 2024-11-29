package problem.easy.Contains_Duplicate_II;
import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Solution 1: HashMap
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        HashMap<Integer, Integer> stored = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(stored.containsKey(nums[i]) && (i - stored.get(nums[i]) <= k)) return true;
            stored.put(nums[i], i);
        }

        return false;
    }
}