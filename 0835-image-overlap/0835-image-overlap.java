class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }

        int[][] count = new int[2 * n + 1][2 * n + 1];
        int maxOverlap = 0;

        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dr = p2[0] - p1[0] + n;
                int dc = p2[1] - p1[1] + n;
                count[dr][dc]++;
                maxOverlap = Math.max(maxOverlap, count[dr][dc]);
            }
        }

        return maxOverlap;
    }
}