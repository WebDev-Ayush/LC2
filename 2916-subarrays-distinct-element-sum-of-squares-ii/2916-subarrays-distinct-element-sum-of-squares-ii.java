import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;

    private long[] sum;
    private long[] sumSq;
    private long[] lazy;

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        val %= MOD;
        sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + len * val % MOD * val % MOD) % MOD;
        sum[node] = (sum[node] + len * val) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] == 0) return;
        int mid = (l + r) >> 1;
        apply(node << 1, l, mid, lazy[node]);
        apply(node << 1 | 1, mid + 1, r, lazy[node]);
        lazy[node] = 0;
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) >> 1;
        if (ql <= mid) {
            update(node << 1, l, mid, ql, qr, val);
        }
        if (qr > mid) {
            update(node << 1 | 1, mid + 1, r, ql, qr, val);
        }
        sum[node] = (sum[node << 1] + sum[node << 1 | 1]) % MOD;
        sumSq[node] = (sumSq[node << 1] + sumSq[node << 1 | 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long total = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastSeen.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, prev + 1, i, 1);
            total = (total + sumSq[1]) % MOD;
            lastSeen.put(nums[i], i);
        }

        return (int) total;
    }
}