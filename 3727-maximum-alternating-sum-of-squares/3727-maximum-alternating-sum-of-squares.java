import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(sq);

        int pos = (n + 1) / 2;
        long ans = 0;

        for (int i = 0; i < n - pos; i++) {
            ans -= sq[i];
        }
        for (int i = n - pos; i < n; i++) {
            ans += sq[i];
        }

        return ans;
    }
}