import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int costI = costs[i - 1];
            for (int k = 1; k <= 3; k++) {
                if (i - k >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - k] + k * k + costI);
                }
            }
        }

        return dp[n];
    }
}