public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrack(n, 0, new int[n], result);
        return result;
    }

    private void backtrack(int n, int row, int[] positions, List<List<String>> result) {
        if (row == n) {
            result.add(generateBoard(positions, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(positions, row, col)) {
                positions[row] = col;
                backtrack(n, row + 1, positions, result);
                positions[row] = -1; // Reset the row after exploring the option
            }
        }
    }

    private boolean isValid(int[] positions, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (positions[i] == col || Math.abs(positions[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateBoard(int[] positions, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[positions[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
