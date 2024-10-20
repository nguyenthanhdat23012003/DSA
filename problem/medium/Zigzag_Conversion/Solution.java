package problem.medium.Zigzag_Conversion;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        List<StringBuilder> rows = new ArrayList<>();
        int n = s.length();
        int upFlag = 0;
        int indexRow = 0;

        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }

        for(int i = 0; i < n; i++){
            rows.get(indexRow).append(s.charAt(i));
            if(upFlag == 0) {
                indexRow++;
                if(indexRow == numRows - 1){
                    upFlag = 1;
                }
            } else {
                indexRow--;
                if(indexRow == 0){
                    upFlag = 0;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            result.append(rows.get(i));
        }

        return result.toString();
    }
}