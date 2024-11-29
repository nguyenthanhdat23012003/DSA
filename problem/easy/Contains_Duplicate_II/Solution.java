package problem.easy.Contains_Duplicate_II;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // // Solution 1: HashMap
        // // Time Complexity: O(n)
        // // Space Complexity: O(n)
        // HashMap<Integer, Integer> stored = new HashMap<>();

        // for(int i = 0; i < nums.length; i++){
        //     if(stored.containsKey(nums[i]) && (i - stored.get(nums[i]) <= k)) return true;
        //     stored.put(nums[i], i);
        // }

        // return false;

        // Solution 2: Sliding Window
        // Time Complexity: O(n * k)
        // Space Complexity: O(1)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}