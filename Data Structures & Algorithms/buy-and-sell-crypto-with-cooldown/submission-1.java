class Solution {

    int[][] t = new int[5000][2]; 
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        for(int[] row : t){
            Arrays.fill(row, -1); 
        }
        return solve(prices, 0, n, true); 
    }

    

    private int solve(int[] prices, int day, int n, boolean buyFlag) {
        if (day >= n)
            return 0;
        
        int flag = buyFlag ? 1 : 0; 
        
        if(t[day][flag] != -1) 
            return t[day][flag]; 

        int maxProfit = 0;

        if (buyFlag) {
            int bought = solve(prices, day + 1, n, false) - prices[day]; //selling - costprice = profit
            int notBought = solve(prices, day + 1, n, true); //still bought func call
            maxProfit = Math.max(maxProfit, Math.max(bought, notBought));

        } else {
            int sold = prices[day] + solve(prices, day + 2, n, true); //after sell buy func will call
            int notSold = solve(prices, day + 1, n, false);
            maxProfit = Math.max(maxProfit, Math.max(sold, notSold));

        }

        t[day][flag] = maxProfit;

        return maxProfit; 
    }
}
