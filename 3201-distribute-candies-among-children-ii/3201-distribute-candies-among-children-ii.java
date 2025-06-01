class Solution {
    public long distributeCandies(int n, int limit) {
        long total = combinations(n + 2, 2);

        for (int i = 0; i < 3; i++) {
            int over = n - (limit + 1);
            if (over >= 0) {
                total -= combinations(over + 2, 2);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int over = n - 2 * (limit + 1);
                if (over >= 0) {
                    total += combinations(over + 2, 2);
                }
            }
        }

        int over = n - 3 * (limit + 1);
        if (over >= 0) {
            total -= combinations(over + 2, 2);
        }

        return total;
    }

    private long combinations(int n, int k) {
        if (n < k) return 0;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res *= n--;
            res /= i;
        }
        return res;
    }
}
