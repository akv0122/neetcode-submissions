class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0)
            return false;

        int target = total / 2;

        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // dp logic
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                int w = nums[i - 1];
                if (w <= j) {
                    // include
                    boolean include = dp[i - 1][j - w];

                    // exclude
                    boolean exclude = dp[i - 1][j];

                    dp[i][j] = include || exclude;
                } else {
                    // cannot include current num
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target]; 
    }
}
