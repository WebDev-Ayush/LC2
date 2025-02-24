class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            
            for (int col = 1; col < row; col++) {
                currentRow.add(result.get(row - 1).get(col - 1) + result.get(row - 1).get(col));
            }
            
            if (row > 0) {
                currentRow.add(1);
            }
            
            result.add(currentRow);
        }
        
        return result;
    }
}
