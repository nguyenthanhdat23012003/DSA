package problem.easy.Valid_Palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        String formatString = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        for(int i = 0; i < formatString.length()/2; i++){
            if(formatString.charAt(i) != formatString.charAt(formatString.length() - i - 1)) return false;
        }

        return true;
    }
}