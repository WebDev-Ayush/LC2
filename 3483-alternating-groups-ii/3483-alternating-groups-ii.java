class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;

        boolean isPerfectlyAlternating = true;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            if (colors[i] == colors[next]) {
                isPerfectlyAlternating = false;
                break;
            }
        }

        if (isPerfectlyAlternating) {
            return n;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int j = 0; j < k; j++) {
                int current = (i + j) % n;
                int next = (i + j + 1) % n;
                if (j < k - 1 && colors[current] == colors[next]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }

        return count;
    }
}