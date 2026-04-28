class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int k = 0;

        for (int[] row : grid) {
            for (int num : row) {
                arr[k++] = num;
            }
        }

        int mod = arr[0] % x;
        for (int num : arr) {
            if (num % x != mod) return -1;
        }

        java.util.Arrays.sort(arr);
        int median = arr[arr.length / 2];

        int ops = 0;
        for (int num : arr) {
            ops += Math.abs(num - median) / x;
        }

        return ops;
    }
}