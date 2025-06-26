class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        long value = 0;
        long power = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                count++;
            } else {
                if (power <= k && value + power <= k) {
                    value += power;
                    count++;
                }
            }

            power *= 2;
            if (power > k) break;
        }

        for (int i = s.length() - count - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') count++;
        }

        return count;
    }
}
