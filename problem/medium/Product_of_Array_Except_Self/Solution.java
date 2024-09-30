package problem.medium.Product_of_Array_Except_Self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for(int i = 1; i < n; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right_product = 1;
        for(int i = n - 1; i >= 0; i--){
            answer[i]*=right_product;
            right_product*=nums[i];
        }

        return answer;
    }
}