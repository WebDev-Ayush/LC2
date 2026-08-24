class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int currentPrefixSum = 0;
        
        // Calculate the total sum of the array, which is prefix[n-1]
        for (int stone : stones) {
            currentPrefixSum += stone;
        }
        
        // Base case: If we must pick all stones (the only choice left)
        int maxDifference = currentPrefixSum;
        
        // Work backwards from the second-to-last index down to 1
        for (int i = n - 2; i >= 1; i--) {
            // Subtract stones[i + 1] from currentPrefixSum to get prefix[i]
            currentPrefixSum -= stones[i + 1];
            
            // Choose either to NOT pick at this index (keep maxDifference)
            // or to PICK at this index (currentPrefixSum - maxDifference)
            maxDifference = Math.max(maxDifference, currentPrefixSum - maxDifference);
        }
        
        return maxDifference;
    }
}