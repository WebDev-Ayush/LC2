import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX_N = 10001;
    static final int MAX_K = 15;
    static long[][] comb = new long[MAX_N][MAX_K];

    public int idealArrays(int n, int maxValue) {
        computeCombinations(n);

        int limit = maxValue;
        int k = 14; // Max chain length we care about

        long[] count = new long[limit + 1];
        Arrays.fill(count, 1);

        long res = 0;

        for (int len = 1; len <= k; len++) {
            long[] next = new long[limit + 1];
            for (int i = 1; i <= limit; i++) {
                for (int j = i * 2; j <= limit; j += i) {
                    next[j] = (next[j] + count[i]) % MOD;
                }
            }

            for (int i = 1; i <= limit; i++) {
                res = (res + count[i] * comb[n - 1][len - 1]) % MOD;
            }

            count = next;
        }

        return (int) res;
    }

    void computeCombinations(int n) {
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j < MAX_K; j++) {
                if (i - 1 >= 0)
                    comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }
    }
}
