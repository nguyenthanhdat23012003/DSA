package problem.medium.Longest_Substring_Without_Repeating_Characters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Soution 1: Dynamic-size Sliding + Character Index Array (Store last index of each character in array and get to check if the character exist in current substring)
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int[] characterLastIndex = new int[256];
        for(int i = 0; i < 256; i++){
            characterLastIndex[i] = -1;
        }

        int maxLength = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(characterLastIndex[current] >= start) {
                start = characterLastIndex[current] + 1;
            }

            characterLastIndex[current] = i;
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}