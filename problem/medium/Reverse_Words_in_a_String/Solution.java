package problem.medium.Reverse_Words_in_a_String;

import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        // Solution 1: Traverse through String and store substring to stack 
        // Time Complexity: O(n)
        // Space Complexity: O(n) (Stack)
        Stack<String> stackWord = new Stack<>();

        String currentWord = "";
        for(char c : s.toCharArray()) {
            if(c != ' ') {
                currentWord += c;
            } else {
                if (!currentWord.isEmpty()) {
                    stackWord.push(currentWord);
                    currentWord = "";
                }
            }
        }

        if (!currentWord.isEmpty()) {
            stackWord.push(currentWord);
        }

        String result = "";
        while(!stackWord.isEmpty()) {
            result += stackWord.pop();
            if (!stackWord.isEmpty()) {
                result += " "; 
            }
        }
        return result;

        // // Solution 2: Two Pointer
        // // Time Complexity: O(n)
        // // Space Complexity: O(n)
        // s = s.trim();
        
        // int i = s.length() - 1;
        // int j = i;
        // StringBuilder result = new StringBuilder();
        
        // while (i >= 0) {
        //     while (i >= 0 && s.charAt(i) != ' ') {
        //         i--;
        //     }
            
        //     result.append(s.substring(i + 1, j + 1)).append(" ");
            
        //     while (i >= 0 && s.charAt(i) == ' ') {
        //         i--;
        //     }
            
        //     j = i;
        // }
        
        // return result.toString().trim();
    }
}
