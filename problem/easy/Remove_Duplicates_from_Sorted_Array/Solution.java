package problem.easy.Remove_Duplicates_from_Sorted_Array;

class Solution {
    // Solution: Two Pointers

    public int removeDuplicates(int[] nums) {
        int d = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[d] = nums[i];
                d++;
            }
        }

        return d;
    }
}
