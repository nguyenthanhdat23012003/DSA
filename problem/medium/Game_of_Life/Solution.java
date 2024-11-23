package problem.medium.Game_of_Life;

class Solution {
    public void gameOfLife(int[][] board) {
        // Solution 1: Copy matrix to count neighbors
        // Time Complexity: O(m * n)
        // Space Complexity: O(m * n)
        int[][] expandBoard = new int[board.length + 2][board[0].length + 2];
        for(int i = 0; i < expandBoard.length; i++){
            for(int j = 0; j < expandBoard[0].length; j++){
                if(i == 0 || j == 0 || i == expandBoard.length - 1 || j == expandBoard[0].length - 1){
                    expandBoard[i][j] = 0;
                } else {
                    expandBoard[i][j] = board[i - 1][j - 1];
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int sum = sumNeighbors(expandBoard, i + 1, j + 1);
                if(board[i][j] == 1){
                    if(sum != 2 && sum != 3){
                        board[i][j] = 0;
                    }
                } else {
                    if(sum == 3) board[i][j] = 1;
                }
            }
        }
    }

    private int sumNeighbors(int[][] board, int i, int j){
        return board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1]
        + board[i][j - 1] + board[i][j + 1]
        + board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1];
    }
}