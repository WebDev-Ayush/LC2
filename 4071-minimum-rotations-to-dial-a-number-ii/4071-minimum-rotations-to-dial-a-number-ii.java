class Solution {
    public int minRotations(int n, String s) {
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = s.charAt(i) - '0';
        }

        int[] origCost = new int[n];
        origCost[0] = dist(0, d[0]);
        for (int i = 1; i < n; i++) {
            origCost[i] = dist(d[i - 1], d[i]);
        }

        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + origCost[i];
        }

        int minTotal = pref[n];

        for (int k = 0; k < n; k++) {
            int prevDigit = (k == 0) ? 0 : d[k - 1];
            int originalEntryCost = origCost[k];
            int newEntryCost = dist(prevDigit, d[n - 1]);

            int totalWithReversal = pref[n] - originalEntryCost + newEntryCost;
            if (totalWithReversal < minTotal) {
                minTotal = totalWithReversal;
            }
        }

        return minTotal;
    }

    private int dist(int a, int b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 10 - diff);
    }
}