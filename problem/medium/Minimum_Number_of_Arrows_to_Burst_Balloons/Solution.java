package problem.medium.Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;

class Solution {
    // // Solution 1: Greedy
    // // Time Complexity: O(n * log(n))
    // // Space Complexity: O(1)
    // public int findMinArrowShots(int[][] points) {
    //     Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
    //     int result = 1;
    //     int end = points[0][1];
    //     for(int i = 1; i < points.length; i++){
    //         if(points[i][0] > end){
    //             result++;
    //             end = points[i][1];
    //         }
    //     }

    //     return result;
    // }

    // Solution 2: Interval Sweeping (Same Greedy)
    // Time Complexity: O(n * log(n))
    // Space Complexity: O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 1;
        int currentEnd = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > currentEnd){
                result++;
                currentEnd = points[i][1];
            } else {
                currentEnd = Math.min(currentEnd, points[i][1]);
            }
        }
        return result;
    }
}