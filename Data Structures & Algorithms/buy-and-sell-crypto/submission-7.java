class Solution {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // profit case

            if (prices[i] > buyingPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - buyingPrice);
            } else {
                buyingPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
