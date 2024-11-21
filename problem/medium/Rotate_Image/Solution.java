package problem.medium.Rotate_Image;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i < j){
                    crossSwap(matrix, i, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j < n / 2){
                    verticalSwap(matrix, i, j);
                }
            }
        }
    }

    public void crossSwap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public void verticalSwap(int[][] matrix, int i, int j){
        int n = matrix.length;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
    }
}