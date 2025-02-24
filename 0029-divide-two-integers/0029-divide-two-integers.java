class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;

        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            int count = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }
            absDividend -= temp;
            result += count;
        }

        return isNegative ? -result : result;
    }
}