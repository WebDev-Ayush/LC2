class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }
        
        if (sum % 4 != 0) return false;
        
        int sideLength = sum / 4;
        Arrays.sort(matchsticks);
        
        return canFormSquare(matchsticks, new int[4], matchsticks.length - 1, sideLength);
    }
    
    private boolean canFormSquare(int[] matchsticks, int[] sides, int index, int sideLength) {
        if (index == -1) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= sideLength) {
                sides[i] += matchsticks[index];
                if (canFormSquare(matchsticks, sides, index - 1, sideLength)) {
                    return true;
                }
                sides[i] -= matchsticks[index];
            }
            if (sides[i] == 0) break;
        }
        
        return false;
    }
}
