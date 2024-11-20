package problem.medium.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] result = new int[matrix.length * matrix[0].length];
        int idx = 0;
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                result[idx] = matrix[top][i];
                idx++;
            }
            top++;

            for(int i = top; i <= bottom; i++){
                result[idx] = matrix[i][right];
                idx++;
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    result[idx] = matrix[bottom][i];
                    idx++;
                }
                bottom--;
            }
            
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    result[idx] = matrix[i][left];
                    idx++;
                }
                left++;
            }
        }

        List<Integer> lastResult = new ArrayList<>();
        for(int i = 0; i < result.length; i++){
            lastResult.add(result[i]);
        }

        return lastResult;
    }
}