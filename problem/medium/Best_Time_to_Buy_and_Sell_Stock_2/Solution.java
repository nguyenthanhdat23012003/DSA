package problem.medium.Best_Time_to_Buy_and_Sell_Stock_2;

class Solution {
    // Solution: Greedy + Two Pointer
    // Time complexity: O(n)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyIdx = 0;

        for (int sellIdx = 1; sellIdx < prices.length; sellIdx++) {
            int profit = prices[sellIdx] - prices[buyIdx];
            if (profit > 0) {
                maxProfit += profit;
            } 
            buyIdx = sellIdx;
        }

        return maxProfit;
    }
}