class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            if (diff[i] > maxDiff) {
                maxDiff = diff[i];
            }
        }

        int[] count = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }

        long k = (long) k1 + k2;

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) continue;

            if (k >= count[d]) {
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                count[d - 1] += k;
                count[d] -= k;
                k = 0;
            }
        }

        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                ans += (long) count[d] * d * d;
            }
        }

        return ans;
    }
}