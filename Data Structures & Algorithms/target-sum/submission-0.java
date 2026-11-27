class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        if (Math.abs(target) > totalSum)
            return 0;
        if ((totalSum + target) % 2 != 0)
            return 0;

        // find no of subsets to get the sum value.
        int sum = (totalSum + target) / 2;

        int[] dp = new int[sum + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }

        return dp[sum];
    }
}
