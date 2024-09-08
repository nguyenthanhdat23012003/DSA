package problem.easy.Majority_Element;

class Solution {
    // Solution 1: Sort and return the middle of the array
    // Time Complexity: O(n^2)

    //Solution 2: Boyer-Moore algorithm
    // Time Complexity: O(n)
    public int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == candidate) {
                count++;
            }
            else {
                count--;
            }

            if(count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        
        return candidate;
    }
}