class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if( n == 1) return nums[0];

        int[] skipFirstHouse = new int[n - 1];
        int[] skipLastHouse = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            skipFirstHouse[i] = nums[i + 1];
            skipLastHouse[i] = nums[i];
        }

        return Math.max(helper(skipFirstHouse), helper(skipLastHouse));
    }

    public int helper(int[] nums1) {
        int n = nums1.length;

        if (n == 0)
            return 0;
        if (n == 1)
            return nums1[0];

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums1[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums1[i - 1]);
        }

        return dp[n];
    }
}
