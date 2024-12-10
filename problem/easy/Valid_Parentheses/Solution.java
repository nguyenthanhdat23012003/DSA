package problem.easy.Valid_Parentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stored = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stored.push(c);
            } else {
                 if (stored.isEmpty()) {
                    return false;
                }
                char top = stored.pop();
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stored.isEmpty();
    }
}  