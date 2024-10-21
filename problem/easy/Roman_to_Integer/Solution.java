package problem.easy.Roman_to_Integer;

import java.util.Hashtable;

class Solution {
    public int romanToInt(String s) {
        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("I", 1);
        table.put("V", 5);
        table.put("X", 10);
        table.put("L", 50);
        table.put("C", 100);
        table.put("D", 500);
        table.put("M", 1000);

        int i = 0;
        int sum = 0;

        while (i < s.length() - 1) {
            String current = String.valueOf(s.charAt(i));
            String next = String.valueOf(s.charAt(i + 1));

            if (table.get(current) >= table.get(next)) {
                sum += table.get(current);
            } else {
                sum -= table.get(current);
            }
            i++;
        }

        // Add the value of the last character
        sum += table.get(String.valueOf(s.charAt(s.length() - 1)));
        
        return sum;
    }
}
