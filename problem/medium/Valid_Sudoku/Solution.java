package problem.medium.Valid_Sudoku;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays of hash sets to track digits in rows, columns, and sub-boxes
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] boxSets = new HashSet[9];

        // Initialize each set
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        // Iterate over the board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];

                // Skip empty cells
                if (value == '.') continue;

                // Calculate box index
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Check for duplicates in row, column, and box
                if (rowSets[row].contains(value) ||
                    colSets[col].contains(value) ||
                    boxSets[boxIndex].contains(value)) {
                    return false;
                }

                // Add value to the respective sets
                rowSets[row].add(value);
                colSets[col].add(value);
                boxSets[boxIndex].add(value);
            }
        }

        // If no duplicates are found, the board is valid
        return true;
    }
}
