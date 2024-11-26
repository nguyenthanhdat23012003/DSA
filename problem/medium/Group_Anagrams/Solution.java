package problem.medium.Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sorted = new String[strs.length];
        for(int i = 0; i < sorted.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            sorted[i] = String.valueOf(charArray);
        }

        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> stringStored = new HashMap<>();

        int idx = 0;
        while(idx < sorted.length){
            if (!stringStored.containsKey(sorted[idx])) {
                stringStored.put(sorted[idx], result.size());
                result.add(new ArrayList<>());
            }

            result.get(stringStored.get(sorted[idx])).add(strs[idx]);
            idx++;
        }

        return result;
    }
}