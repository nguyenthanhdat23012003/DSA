package problem.medium.Set_Matrix_Zeroes;

import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {
        // Solution 1: Save index row and column to HashSet and check
        // Time Complexity: O(n * m)
        // Space Complexity: O(m + n)
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(!row.contains(i)) row.add(i);
                    if(!column.contains(j)) column.add(j);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(row.contains(i) || column.contains(j)) matrix[i][j] = 0;
            }
        }
    }
}