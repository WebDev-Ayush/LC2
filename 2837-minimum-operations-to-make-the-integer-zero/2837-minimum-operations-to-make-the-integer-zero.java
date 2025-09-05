class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long diff = (long) num1 - (long) num2 * k;
            if (diff < k) continue;
            if (Long.bitCount(diff) <= k && k <= diff) return k;
        }
        return -1;
    }
}
