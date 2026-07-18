class Solution {
    public int maxProfit(int[] prices) {
       
       int maxProfit = 0; 
       int minBuy = prices[0]; 

       for(int sell : prices){
        maxProfit = Math.max(maxProfit, sell - minBuy); 
        minBuy = Math.min(minBuy, sell); 

       }

       return maxProfit; 


    }
}
