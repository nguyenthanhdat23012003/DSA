package problem.easy.Happy_Number;

class Solution {
    public boolean isHappy(int n) {
        // // Solution 1: HashSet
        // Set<Integer> store = new HashSet<>();
        // while(n != 1 && !store.contains(n)){
        //     store.add(n);
        //     n = getSumOfSquares(n);
        // }

        // return n == 1;

        // Solution 2: Floyd's Cycle Detection Algorithm
        int slow = n;
        int fast = getSumOfSquares(n);

        while(fast != 1 && slow != fast){
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }

        return fast == 1;
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