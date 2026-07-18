class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > buyingPrice) { // profit case
                int profit = prices[i] - buyingPrice; //basically todays profit
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyingPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
