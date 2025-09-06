class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long total = 0;
            long p = 1;
            while (p <= r) {
                long start = Math.max(l, p);
                if (start <= r) total += r - start + 1;
                if (p > r / 4) break;
                p *= 4;
            }
            ans += (total + 1) / 2;
        }
        return ans;
    }
}
