package problem.easy.Merge_Sorted_Array;

class Solution {
    // Solution 1: Merge -> Sort
    // Time complexity: O((m+n)^2) -> not optimal

    // Solution 2: Two Array Pointer
    // Time complexity: O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; 
        int p2 = n - 1; 
        int p = m + n - 1; 
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1]; 
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--; 
        }

        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }
    }
}
