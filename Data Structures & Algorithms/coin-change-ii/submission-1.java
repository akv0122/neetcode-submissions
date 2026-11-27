class Solution {
    public int change(int amount, int[] coins) {

        //return combinations that sum up to the given amount. else zero

        int[] dp = new int[amount + 1]; //sum 0 also we need to consider thatswhsy + 1

        //base case
        dp[0] = 1; //one way to make amount 0 is take nothing. 

        
        for( int coin : coins){
            for(int i = coin; i<= amount; i++){
                dp[i] = dp[i - coin] + dp[i]; 
            }
        }
        

        return dp[amount]; 
        


        
    }
}
