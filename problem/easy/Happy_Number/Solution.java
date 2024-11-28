package problem.easy.Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        // Solution 1: HashSet
        Set<Integer> store = new HashSet<>();
        while(n != 1 && !store.contains(n)){
            store.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}