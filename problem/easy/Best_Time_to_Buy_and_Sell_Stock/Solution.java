package problem.easy.Best_Time_to_Buy_and_Sell_Stock;

class Solution {
    // Solution 1
    // Traverse sellIdx in array, buyIdx is not change 'til profit < 0
    // Time Complexity: O(n)
    public int maxProfit(int[] prices) {
        int max = 0;
        int sellIdx = 0;
        int buyIdx = 0;
        while (sellIdx < prices.length) {
            int profit = prices[sellIdx] - prices[buyIdx];
            if(profit < 0) {
                buyIdx = sellIdx;
            } else if(profit > max) {
                max = profit;
            }
            sellIdx++;
        }
        return max;
    }

    // Solution 2
    // public int maxProfit(int[] prices) {
        
    // }
}