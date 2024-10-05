package problem.hard.Trapping_Rain_Water;
import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        // // Solution 1: Brute Force
        // // Time Complexity: O(n^2)
        // // Space Complexity: O(1)
        // int n = height.length;
        // int trap = 0;
        // for(int i = 1; i < n - 1; i++){
        //     int maxLeft = 0;
        //     int maxRight = 0;
        //     for(int j = 0; j < i; j++){
        //         if(height[j] > maxLeft && height[j] > height[i]) maxLeft = height[j];
        //     }
        //     for(int j = i + 1; j < n; j++){
        //         if(height[j] > maxRight && height[j] > height[i]) maxRight = height[j];
        //     }
        //     if(maxLeft == 0 || maxRight == 0){
        //         continue;
        //     }
        //     trap+=(min(maxLeft, maxRight) - height[i]);
        // }
        // return trap;

        // // Solution 2: Improve Brute Force, DP
        // // Time Complexity: O(n)
        // // Space Complexity: O(n)
        // int n = height.length;
        // int trap = 0;
        // int[] maxLeft = new int[n];
        // int[] maxRight = new int[n];

        // maxLeft[0] = height[0];
        // for(int i = 1; i < n; i++){
        //     maxLeft[i] = max(maxLeft[i - 1], height[i]);
        // }

        // maxRight[n - 1] = height[n - 1];
        // for(int i = n - 2; i >= 0; i--){
        //     maxRight[i] = max(maxRight[i + 1], height[i]);
        // }

        // for (int i = 0; i < n; i++) {
        //     trap += min(maxLeft[i], maxRight[i]) - height[i];
        // }

        // return trap;

        // // Solution 3: Two Pointer
        // int left = 0;
        // int right = height.length - 1;
        // int maxLeft = 0;
        // int maxRight = 0;
        // int trap = 0;
        // while(left <= right){
        //     if(height[left] < height[right]){
        //         if(height[left] > maxLeft){
        //             maxLeft = height[left];
        //         } else {
        //             trap+=(maxLeft - height[left]);
        //         }
        //         left++;
        //     } else {
        //         if(height[right] > maxRight){
        //             maxRight = height[right];
        //         } else {
        //             trap+=(maxRight - height[right]);
        //         }
        //         right--;
        //     }
        // }

        // return trap;

        // Solution 4: Stack, Monotonic Stack
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int trap = 0;
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int distance = i - stack.peek() - 1;
                int boundedHeight = min(height[i], height[stack.peek()]) - height[top];
                trap += distance * boundedHeight;
            }
            stack.push(i);
        }

        return trap;
    }

    public int min(int a, int b){
        return (a < b) ? a : b;
    }

    public int max(int a, int b){
        return (a > b) ? a : b;
    }
}