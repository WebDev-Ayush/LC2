import java.util.Arrays;

class Solution {
    private int[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Calculate prefix sums for O(1) range sum queries
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        return solve(0, n - 1);
    }

    private int solve(int i, int j) {
        // Base case: only one stone left, no more score can be earned
        if (i == j) {
            return 0;
        }

        // Return cached result if already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int maxScore = 0;

        // Try all possible split points between i and j
        for (int k = i; k < j; k++) {
            int leftSum = getSum(i, k);
            int rightSum = getSum(k + 1, j);

            int currentScore = 0;
            if (leftSum < rightSum) {
                // Bob throws away right row, Alice gets leftSum + solves left subproblem
                currentScore = leftSum + solve(i, k);
            } else if (leftSum > rightSum) {
                // Bob throws away left row, Alice gets rightSum + solves right subproblem
                currentScore = rightSum + solve(k + 1, j);
            } else {
                // Equal sums: Alice chooses the row that yields maximum score
                currentScore = leftSum + Math.max(solve(i, k), solve(k + 1, j));
            }

            maxScore = Math.max(maxScore, currentScore);
        }

        return memo[i][j] = maxScore;
    }

    private int getSum(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}