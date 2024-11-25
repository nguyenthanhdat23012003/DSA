package problem.easy.Word_Pattern;

import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); 
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> stored = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = words[i];
            
            if (stored.containsKey(patternChar)) {
                if (!stored.get(patternChar).equals(word)) {
                    return false; 
                }
            } else if (stored.containsValue(word)) {
                return false; 
            } else {
                stored.put(patternChar, word); 
            }
        }
        
        return true;
    }
}
