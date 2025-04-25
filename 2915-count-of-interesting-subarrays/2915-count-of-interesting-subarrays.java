import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> prefixCount = new HashMap<>();
        prefixCount.put(0, 1L);

        int cnt = 0;
        long total = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                cnt++;
            }

            int currMod = cnt % modulo;
            int target = (currMod - k + modulo) % modulo;

            total += prefixCount.getOrDefault(target, 0L);
            prefixCount.put(currMod, prefixCount.getOrDefault(currMod, 0L) + 1);
        }

        return total;
    }
}
