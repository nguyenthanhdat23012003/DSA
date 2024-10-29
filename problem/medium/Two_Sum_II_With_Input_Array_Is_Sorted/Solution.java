package problem.medium.Two_Sum_II_With_Input_Array_Is_Sorted;

class Solution {
    // Solution: Two Pointer
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int result[] = new int[2];
        int left = 0;
        int right = n - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum > target){
                right--;
            } else if (sum < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }

        return result;
    }
}