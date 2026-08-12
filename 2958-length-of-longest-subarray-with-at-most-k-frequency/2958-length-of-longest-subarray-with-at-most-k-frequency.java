import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentVal = nums[right];
            freqMap.put(currentVal, freqMap.getOrDefault(currentVal, 0) + 1);

            while (freqMap.get(currentVal) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}