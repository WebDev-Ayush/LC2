class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int currentPrefixSum = 0;
        
        for (int stone : stones) {
            currentPrefixSum += stone;
        }
        
        int maxDifference = currentPrefixSum;
        
        for (int i = n - 2; i >= 1; i--) {
            currentPrefixSum -= stones[i + 1];
            maxDifference = Math.max(maxDifference, currentPrefixSum - maxDifference);
        }
        
        return maxDifference;
    }
}