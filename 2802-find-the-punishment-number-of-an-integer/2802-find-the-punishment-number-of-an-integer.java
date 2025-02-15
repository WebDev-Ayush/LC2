class Solution {
    public int punishmentNumber(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (isPunishmentNumber(i)) {
                total += i * i;
            }
        }
        return total;
    }

    private boolean isPunishmentNumber(int i) {
        int square = i * i;
        String squareStr = Integer.toString(square);
        return backtrack(squareStr, 0, 0, i);
    }

    private boolean backtrack(String s, int index, int currentSum, int target) {
        if (index == s.length()) {
            return currentSum == target;
        }
        for (int j = index + 1; j <= s.length(); j++) {
            int num = Integer.parseInt(s.substring(index, j));
            if (backtrack(s, j, currentSum + num, target)) {
                return true;
            }
        }
        return false;
    }
}