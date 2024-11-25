package problem.easy.Valid_Anagram;

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // // Solution 1: Sort and compare
        // if (s.length() != t.length()) {
        //     return false;
        // }
        
        // char[] sArray = s.toCharArray();
        // char[] tArray = t.toCharArray();
        // Arrays.sort(sArray);
        // Arrays.sort(tArray);
        
        // return Arrays.equals(sArray, tArray);

        // Solution 2: HashMap 
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false; 
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c); 
            }
        }
        
        return charCountMap.isEmpty();
    }
}