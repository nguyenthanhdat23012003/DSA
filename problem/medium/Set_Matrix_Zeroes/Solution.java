package problem.medium.Set_Matrix_Zeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        // // Solution 1: Save index row and column to HashSet and check
        // // Time Complexity: O(n * m)
        // // Space Complexity: O(m + n)
        // HashSet<Integer> row = new HashSet<>();
        // HashSet<Integer> column = new HashSet<>();
        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[0].length; j++){
        //         if(matrix[i][j] == 0){
        //             if(!row.contains(i)) row.add(i);
        //             if(!column.contains(j)) column.add(j);
        //         }
        //     }
        // }

        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[0].length; j++){
        //         if(row.contains(i) || column.contains(j)) matrix[i][j] = 0;
        //     }
        // }

        // Solution 2: Save index row and column need to update to the first
        // row and first column
        // Time Complexity: O(m * n)
        // Space Complexity: O(1)

        boolean firstRowZero = false; 
        boolean firstColZero = false; 

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}