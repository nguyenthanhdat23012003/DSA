package problem.easy.Ransom_Note;

import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> stored = new HashMap<>();
        for(char c : ransomNote.toCharArray()){
            stored.put(c, stored.getOrDefault(c, 0) + 1);
        }

        for(char c : magazine.toCharArray()){
            if(stored.containsKey(c)){
                stored.put(c, stored.get(c) - 1);
                if(stored.get(c) == 0) stored.remove(c);
            } 
        }

        for(char c : ransomNote.toCharArray()){
            if(stored.containsKey(c)) return false;
        }

        return true;
    }
}