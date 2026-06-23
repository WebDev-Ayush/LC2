class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        if (k <= 0) return 0;
        if (n == 1) return k;

        long MOD = 1000000007;

        long[][] dp = new long[k][2];

        for (int j = 0; j < k; j++) {
            dp[j][0] = k - 1 - j; 
            dp[j][1] = j;         
        }

        for (int i = 3; i <= n; i++) {
            long[][] nextDp = new long[k][2];

            long[] prefDecreasing = new long[k];
            prefDecreasing[0] = dp[0][0];
            for (int j = 1; j < k; j++) {
                prefDecreasing[j] = (prefDecreasing[j - 1] + dp[j][0]) % MOD;
            }

            long[] suffIncreasing = new long[k];
            suffIncreasing[k - 1] = dp[k - 1][1];
            for (int j = k - 2; j >= 0; j--) {
                suffIncreasing[j] = (suffIncreasing[j + 1] + dp[j][1]) % MOD;
            }

            for (int j = 0; j < k; j++) {
                if (j < k - 1) {
                    nextDp[j][0] = suffIncreasing[j + 1];
                }
                if (j > 0) {
                    nextDp[j][1] = prefDecreasing[j - 1];
                }
            }
            dp = nextDp;
        }

        long totalCount = 0;
        for (int j = 0; j < k; j++) {
            totalCount = (totalCount + dp[j][0] + dp[j][1]) % MOD;
        }

        return (int) totalCount;
    }
}