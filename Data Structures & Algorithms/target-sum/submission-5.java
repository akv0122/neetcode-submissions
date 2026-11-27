class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum)
            return 0;

        if ((totalSum + target) % 2 != 0)
            return 0;

        int W = (totalSum + target) / 2;

        int[][] dp = new int[n + 1][W + 1]; // number of subsets with sum j using first i elements

        // base case
        dp[0][0] = 1; //one way to make sum 0 using zero elements. 

        // dp logic
        for (int i = 1; i < n + 1; i++) {

            int num = nums[i - 1];

            for (int j = 0; j < W + 1; j++) {

                if (num <= j) {
                    // include current element
                    int include = dp[i - 1][j - num];

                    // exclude
                    int exclude = dp[i - 1][j];

                    dp[i][j] = include + exclude; 
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
