package problem.medium.Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<String> stored = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int b = Integer.parseInt(stored.pop());
                int a = Integer.parseInt(stored.pop());
                result = a + b;
                stored.push(Integer.toString(result));
            } else if (tokens[i].equals("-")) {
                int b = Integer.parseInt(stored.pop());
                int a = Integer.parseInt(stored.pop());
                result = a - b; 
                stored.push(Integer.toString(result));
            } else if (tokens[i].equals("*")) {
                int b = Integer.parseInt(stored.pop());
                int a = Integer.parseInt(stored.pop());
                result = a * b;
                stored.push(Integer.toString(result));
            } else if (tokens[i].equals("/")) {
                int b = Integer.parseInt(stored.pop());
                int a = Integer.parseInt(stored.pop());
                result = a / b; 
                stored.push(Integer.toString(result));
            } else {
                stored.push(tokens[i]);
            }
        }

        return Integer.parseInt(stored.peek());
    }
}
