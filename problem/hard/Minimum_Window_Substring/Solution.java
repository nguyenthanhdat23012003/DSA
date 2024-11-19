package problem.hard.Minimum_Window_Substring;

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        // Solution: Sliding Window + HashMap
        // Time Complexity: O(m + n), traverse s -> m, store HashMap -> n
        // Space Complexity: O(n), HashMap 
        HashMap<Character, Integer> stored = new HashMap<>();
        HashMap<Character, Integer> current = new HashMap<>();

        for(char c : t.toCharArray()){
            stored.put(c, stored.getOrDefault(c, 0) + 1);
        }
        
        int firstIdx = 0, currentIdx = 0, start = 0, minLength = Integer.MAX_VALUE, count = 0;

        while(currentIdx < s.length()){
            char c = s.charAt(currentIdx);

            if(stored.containsKey(c)){
                current.put(c, current.getOrDefault(c, 0) + 1);
                if(current.get(c).intValue() == stored.get(c).intValue()) count++;
            }

            while(count == stored.size()){
                if(currentIdx - firstIdx + 1 < minLength){
                    minLength = currentIdx - firstIdx + 1;
                    start = firstIdx;
                }

                char firstChar = s.charAt(firstIdx);

                if(stored.containsKey(firstChar)) {
                    current.put(firstChar, current.get(firstChar) - 1);
                    if(current.get(firstChar).intValue() < stored.get(firstChar).intValue()) count--;
                }

                firstIdx++;
            }

            currentIdx++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}