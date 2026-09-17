import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        
        Map<Integer, Integer> prefixSumIndex = new HashMap<>();
        prefixSumIndex.put(0, -1);
        
        int prefixSum = 0;
        int minResult = Integer.MAX_VALUE;
        int currentMinLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            
            if (prefixSumIndex.containsKey(prefixSum - target)) {
                int prevIndex = prefixSumIndex.get(prefixSum - target);
                int len = i - prevIndex;
                
                if (prevIndex >= 0 && minLen[prevIndex] != Integer.MAX_VALUE) {
                    minResult = Math.min(minResult, len + minLen[prevIndex]);
                }
                
                currentMinLen = Math.min(currentMinLen, len);
            }
            
            minLen[i] = currentMinLen;
            prefixSumIndex.put(prefixSum, i);
        }
        
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}