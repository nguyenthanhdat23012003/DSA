package problem.easy.Isomorphic_Strings;

import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> stored = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(stored.containsKey(sChar)){
                if(stored.get(sChar) != tChar) return false;
            } else if (stored.containsValue(tChar)){
                return false;
            } else {
                stored.put(sChar, tChar);
            }
        }

        return true;
    }
}