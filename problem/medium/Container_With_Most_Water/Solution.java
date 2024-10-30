package problem.medium.Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        // // Solution 1: Brute Force
        // // Time Complexity: O(n^2)
        // // Space Complexity: O(n)
        // int n = height.length;
        // int max = 0;
        // for(int i = 0; i < n - 1; i++){
        //     for(int j = i + 1; j < n; j++){
        //         int water = (j - i) * (Math.min(height[i], height[j]));
        //         if(water > max) max = water;
        //     }
        // }

        // return max;

        // Solution 2: Greedy
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        int max = 0;

        while (leftIdx < rightIdx) {
            int water = (rightIdx - leftIdx) * Math.min(height[leftIdx], height[rightIdx]);
            max = Math.max(max, water);

            if (height[leftIdx] < height[rightIdx]) {
                leftIdx++;
            } else {
                rightIdx--;
            }
        }

        return max;

    }
}