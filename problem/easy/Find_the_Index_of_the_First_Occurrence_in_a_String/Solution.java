package problem.easy.Find_the_Index_of_the_First_Occurrence_in_a_String;

class Solution {
    public int strStr(String haystack, String needle) {
        // // Solution 1: Two Pointer
        // if (needle.isEmpty()) return 0;
        // int iHaystack = 0;
        // int iNeedle = 0;
        // int hLength = haystack.length();
        // int nLength = needle.length();
        // if (nLength > hLength) return -1;
        // int result = 0;
        // while(iHaystack != hLength){
        //     if(haystack.charAt(iHaystack) == needle.charAt(iNeedle)){
        //         if(iNeedle == 0) result = iHaystack;
        //         iNeedle++;
        //         if (iNeedle == nLength) return result;
        //     } else {
        //         if (iNeedle > 0) {
        //             iHaystack = result;
        //         }
        //         result = 0;
        //         iNeedle = 0;
        //     }

        //     iHaystack++;
        // }

        // return -1;
        
        // Solution 2: Substring
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        int nLength = needle.length();
        int hLength = haystack.length();
        for(int i = 0; i <= hLength - nLength; i++){
            if(haystack.substring(i, i + nLength).equals(needle)) return i;
        }
        
        return -1;
    }
}