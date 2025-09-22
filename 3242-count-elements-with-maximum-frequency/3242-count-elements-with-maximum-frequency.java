import java.util.*;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        
        for (int n : nums) {
            int f = freq.getOrDefault(n, 0) + 1;
            freq.put(n, f);
            maxFreq = Math.max(maxFreq, f);
        }
        
        int total = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) total += f;
        }
        return total;
    }
}
