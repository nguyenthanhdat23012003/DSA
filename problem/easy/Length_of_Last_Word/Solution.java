package problem.easy.Length_of_Last_Word;

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int testLastValue = 0;
        if(String.valueOf(s.charAt(s.length() - 1)).contains(" ")){
            testLastValue = 1;
        }
        if(testLastValue == 1){
            for(int i = s.length() - 1; i >=0; i--){
                if(!String.valueOf(s.charAt(i)).contains(" ")){
                    count++;
                }
                if(String.valueOf(s.charAt(i)).contains(" ") && count != 0) {
                    break;
                }
            }
        } else {
            for(int i = s.length() - 1; i >=0; i--){
                if(String.valueOf(s.charAt(i)).contains(" ")){
                    break;
                } else {
                    count++;
                }
            }
        }

        
        return count;
    }
}