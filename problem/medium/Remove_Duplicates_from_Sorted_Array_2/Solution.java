package problem.medium.Remove_Duplicates_from_Sorted_Array_2;

class Solution {
    // // Solution 1
    // // Check if nums[i] = nums[i-2] -> shift all element from i + 1 to end to the left (= remove nums[i])
    // // Time complexity: Bad case O(n^2)

    // public int removeDuplicates(int[] nums) {
    //     int i = 2; 
    //     int length = nums.length;

    //     while (i < length) {
    //         if (nums[i] == nums[i-2]) {
    //             for (int j = i; j < length - 1; j++) {
    //                 nums[j] = nums[j+1];
    //             }
    //             length--;
    //         } else {
    //             i++; 
    //         }
    //     }

    //     return length; 
    // }

    // Solution 2
    // Two Pointer
    public int removeDuplicates(int[] nums) {
        int a = 2;
        for (int b = 2; b < nums.length; b++) {
            if(nums[b] != nums[a - 2]) {
                nums[a] = nums[b];
                a++;
            }
        }

        return a;
    }
}