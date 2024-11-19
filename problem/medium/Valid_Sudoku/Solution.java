package problem.medium.Valid_Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays of hash sets to track digits in rows, columns, and sub-boxes
        List<HashSet<Character>> rowSets = new ArrayList<>();
        List<HashSet<Character>> colSets = new ArrayList<>();
        List<HashSet<Character>> boxSets = new ArrayList<>();

        // Initialize each set
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            boxSets.add(new HashSet<>());
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
                if (rowSets.get(row).contains(value) ||
                    colSets.get(col).contains(value) ||
                    boxSets.get(boxIndex).contains(value)) {
                    return false;
                }

                // Add value to the respective sets
                rowSets.get(row).add(value);
                colSets.get(col).add(value);
                boxSets.get(boxIndex).add(value);
            }
        }

        // If no duplicates are found, the board is valid
        return true;
    }
}
