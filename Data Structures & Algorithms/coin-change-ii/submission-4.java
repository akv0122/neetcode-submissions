class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1]; 


        //one way to make amount zero. 
        dp[0] = 1;

        for(int coin : coins){
            for(int j = coin; j <= amount; j++){
                dp[j] = dp[j] + dp[j-coin]; 
            }
        } 
        
        return dp[amount]; 

        
    }
}



// class Solution {
//     // O(n^2)
//     public int change(int amount, int[] coins) {
//         int n = coins.length;

//         int[][] dp = new int[n + 1][amount + 1];

//         for (int i = 0; i < n + 1; i++) {
//             dp[i][0] = 1;
//         }

//         for (int i = 1; i < amount + 1; i++) {
//             dp[0][i] = 0;
//         }

//         // dp logic

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 1; j < amount + 1; j++) {
//                 // exclude
//                 dp[i][j] += dp[i - 1][j];

//                 if (j >= coins[i - 1]) {
//                     // include(unlimited reuse)
//                     dp[i][j] += dp[i][j - coins[i-1]];
//                 }


//             }
//         }
//         return dp[n][amount]; 
//     }
// }

