package problem.hard.Candy;

class Solution {
    public int candy(int[] ratings) {
        // // Solution 1: traverse twice from begin to end and end to begin
        // // Time Complexity: O(n)
        // // Space Complexity: O(n)
        // int n = ratings.length;
        // int[] candy = new int[n];
        // candy[0] = 1;
        // for(int i = 1; i < n; i++){
        //     if(ratings[i] > ratings[i - 1]){
        //         candy[i] = candy[i - 1] + 1;
        //     } else {
        //         candy[i] = 1;
        //     }
        // }

        // for(int i = n - 2; i >= 0; i--){
        //     if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]){
        //         candy[i] = candy[i + 1] + 1;
        //     }
        // }

        // int sum = 0;
        // for(int i = 0; i < n; i++){
        //     sum+=candy[i];
        // }

        // return sum;

        // Solution 2: find the decreasing array in the whole array and calculate the sum
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int totalCandies = 0; 
        int currentCandies = 1; // Curent candies for the first children

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                totalCandies += currentCandies; 
                currentCandies++; // Current candies for the next children
            } 
            else if (ratings[i] == ratings[i + 1]) {
                totalCandies += currentCandies;
                currentCandies = 1; // Current candies for the next children
            } 
            else {
                int j; // Index of the next children
                for (j = i + 1; j < ratings.length; j++) {
                    // Traverse til no children has lower rating
                    if (j + 1 >= ratings.length || ratings[j] <= ratings[j + 1]) {
                        break;
                    }
                }
                int numberOfHigherRatedChildren = (j - i); //
                totalCandies += (numberOfHigherRatedChildren * (numberOfHigherRatedChildren + 1) / 2) - 1; // Sum for decreasing array 
                totalCandies += Math.max(numberOfHigherRatedChildren + 1, currentCandies); 
                i = j - 1;
                currentCandies = 1; // Set number of candies for the current children
            }
        }
        totalCandies += currentCandies;
        return totalCandies;
    }
} 