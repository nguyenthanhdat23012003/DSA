package problem.easy.Remove_Element;

class Solution {
    // Solution: Two Array Pointer
    public int removeElement(int[] nums, int val) {
        int k = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++; 
            }
        }
        
        return k;
    }
}
