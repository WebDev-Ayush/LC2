class Solution {
    static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long val = a[i][k];

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + val * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }

    private long[] multiply(long[][] a, long[] v) {
        int n = a.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) continue;
                sum = (sum + a[i][j] * v[j]) % MOD;
            }

            res[i] = sum;
        }

        return res;
    }

    private long[][] power(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;

        if (n == 1) return k;

        int m = 2 * k;

        long[] dp2 = new long[m];

        for (int i = 0; i < k; i++) {
            dp2[i] = i;
            dp2[k + i] = k - 1 - i;
        }

        if (n == 2) {
            long ans = 0;
            for (long x : dp2) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] T = new long[m][m];

        for (int curr = 0; curr < k; curr++) {

            for (int prev = 0; prev < curr; prev++) {
                T[curr][k + prev] = 1;
            }

            for (int prev = curr + 1; prev < k; prev++) {
                T[k + curr][prev] = 1;
            }
        }

        long[][] P = power(T, n - 2);

        long[] dpN = multiply(P, dp2);

        long ans = 0;
        for (long x : dpN) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }
}