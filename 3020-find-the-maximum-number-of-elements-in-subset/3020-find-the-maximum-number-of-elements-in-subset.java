import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put((long) num, counts.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 1;

        if (counts.containsKey(1L)) {
            int oneCount = counts.get(1L);
            if (oneCount % 2 == 0) {
                maxLen = Math.max(maxLen, oneCount - 1);
            } else {
                maxLen = Math.max(maxLen, oneCount);
            }
        }

        for (long num : counts.keySet()) {
            if (num == 1) {
                continue;
            }

            int currentLen = 0;
            long x = num;

            while (counts.containsKey(x) && counts.get(x) >= 2) {
                currentLen += 2;
                if (x > 200000) {
                    x = 200001;
                    break;
                }
                x = x * x;
            }

            if (counts.containsKey(x)) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}