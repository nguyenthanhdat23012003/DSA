package problem.hard.Text_Justification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int lineIdx = 0;
        List<String> result = new ArrayList<>();
        result.add("");

        for(String word : words) {
            if((result.get(lineIdx).length() + word.length() + (result.get(lineIdx).isEmpty() ? 0 : 1)) <= maxWidth){
                if(result.get(lineIdx).length() == 0){
                    result.set(lineIdx, word);
                } else {
                    result.set(lineIdx, result.get(lineIdx) + " " + word);
                }
            } else {
                lineIdx++;
                result.add("");
                result.set(lineIdx, word);
            }
        }

        int resultSize = result.size();
        
        for(int i = 0; i < resultSize - 1; i++) {
            String text = result.get(i);
            int count = 0;

            for(char c : text.toCharArray()) {
                if(c == ' ') count++;
            }

            int spaceToAdd = maxWidth - text.length();
            StringBuilder finalText = new StringBuilder();
            if(count != 0){
                String[] list = text.split(" ");
                int idx = 0;
                int spaceAddEachText = spaceToAdd / count + 1;
                int spaceAddEachTextLeft = spaceToAdd % count;
                while(idx != list.length){
                    finalText.append(list[idx]);
                    if(idx != list.length - 1){
                        int idxSpace = spaceAddEachText ;
                        while(idxSpace != 0){
                            finalText.append(" ");
                            idxSpace--;
                        }
                        if(idx < spaceAddEachTextLeft) {
                            finalText.append(" ");
                        }
                    }
                    idx++;
                }
            } else {
                finalText.append(text);
                for(int j = 0; j < spaceToAdd; j++){
                    finalText.append(" ");
                }
            }

            result.set(i, finalText.toString());
        }

        StringBuilder lastLine = new StringBuilder(result.get(resultSize - 1).trim());
        while (lastLine.length() < maxWidth) {
            lastLine.append(" "); 
        }
        result.set(resultSize - 1, lastLine.toString());

        return result;
    }
}
