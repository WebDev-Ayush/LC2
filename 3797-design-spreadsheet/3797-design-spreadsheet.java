import java.util.*;

class Spreadsheet {
    private int rows;
    private int[][] sheet;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.sheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = 0;
    }

    public int getValue(String formula) {
        if (!formula.startsWith("=")) return 0;
        String[] parts = formula.substring(1).split("\\+");
        int sum = 0;
        for (String part : parts) {
            sum += getOperandValue(part);
        }
        return sum;
    }

    private int getOperandValue(String op) {
        if (op.length() >= 2 && Character.isLetter(op.charAt(0))) {
            int col = op.charAt(0) - 'A';
            int row = Integer.parseInt(op.substring(1)) - 1;
            return sheet[row][col];
        } else {
            return Integer.parseInt(op);
        }
    }
}
