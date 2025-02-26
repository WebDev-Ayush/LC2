public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            currentMin = Math.min(currentMin + num, num);
            
            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
