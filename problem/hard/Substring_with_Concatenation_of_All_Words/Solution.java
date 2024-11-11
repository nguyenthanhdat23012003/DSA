package problem.hard.Substring_with_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // Solution 1: Brute Force + Hash Map
        // Time Complexity: O(n * m * k) 
        // n: String length
        // m: words (array) length
        // k: word (string) length
        // Space Complexity: O(m + n / k)
        int wordLength = words[0].length();
        int sumLength = wordLength * words.length;
        String subString = "";
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> storeWords = new HashMap<>();
        HashMap<String, Integer> check = new HashMap<>();
        int startIdx = 0;

        for(int i = 0; i < words.length; i++){
            if(!storeWords.containsKey(words[i])) storeWords.put(words[i], 1);
            else storeWords.put(words[i], storeWords.get(words[i]) + 1);
        }
        
        check.putAll(storeWords);
        
        while(startIdx + sumLength <= s.length()){
            subString = s.substring(startIdx, startIdx + sumLength);

            for(int i = 0; i < words.length; i++){
                String subSubString = subString.substring(i * wordLength, (i + 1) * wordLength);
                if(!storeWords.containsKey(subSubString)) break;
                else storeWords.put(subSubString, storeWords.get(subSubString) - 1);
                if(storeWords.get(subSubString) == 0) storeWords.remove(subSubString);
            }

            if(storeWords.size() == 0) {
                result.add(startIdx); 
            }

            storeWords.clear();
            storeWords.putAll(check);
            startIdx++;
        }

        return result;
    }
}