package problem.hard.Basic_Calculator;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, result = 0, sign = 1;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            } else if (c == '+'){
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-'){
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')'){
                result += sign * num;
                num = 0;
                result *= stack.pop(); 
                result += stack.pop();
            }
        }

        result += sign * num; 
        return result;
    }
}
