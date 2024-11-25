package problem.easy.Valid_Anagram;

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Solution 1: Sort and compare
        if (s.length() != t.length()) {
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        return Arrays.equals(sArray, tArray);
    }
}