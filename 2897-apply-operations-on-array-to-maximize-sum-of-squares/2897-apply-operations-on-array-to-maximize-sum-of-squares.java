class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];
        for (int x : nums) {
            for (int b = 0; b < 32; b++) {
                if (((x >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }

        long ans = 0;
        long MOD = 1_000_000_007L;

        for (int i = 0; i < k; i++) {
            long val = 0;
            for (int b = 0; b < 32; b++) {
                if (bitCount[b] > 0) {
                    val |= (1L << b);
                    bitCount[b]--;
                }
            }
            ans = (ans + (val % MOD) * (val % MOD)) % MOD;
        }

        return (int) ans;
    }
}