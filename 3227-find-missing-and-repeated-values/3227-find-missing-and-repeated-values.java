class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1];
        int[] ans = new int[2];
        
        for (int[] row : grid) {
            for (int num : row) {
                count[num]++;
            }
        }
        
        for (int i = 1; i <= n * n; i++) {
            if (count[i] == 2) {
                ans[0] = i;
            } else if (count[i] == 0) {
                ans[1] = i;
            }
        }
        
        return ans;
    }
}