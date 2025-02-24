class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int minPath = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, triangle.get(row).get(col) + minPath);
            }
        }
        
        return triangle.get(0).get(0);
    }
}
