import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) return -1;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> levels = new ArrayList<>(freq.keySet());
        Collections.sort(levels, Collections.reverseOrder());

        int ops = 0;
        int[] current = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < levels.size() - 1; i++) {
            int high = levels.get(i);
            int nextHigh = levels.get(i + 1);

            boolean valid = true;
            for (int val : current) {
                if (val > nextHigh && val != high) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ops++;
                for (int j = 0; j < current.length; j++) {
                    current[j] = Math.min(current[j], nextHigh);
                }
            }

            boolean allK = true;
            for (int val : current) {
                if (val != k) {
                    allK = false;
                    break;
                }
            }
            if (allK) return ops;
        }

        boolean needsFinal = false;
        int maxVal = Integer.MIN_VALUE;
        for (int val : current) {
            if (val > k) {
                needsFinal = true;
                maxVal = Math.max(maxVal, val);
            }
        }

        if (needsFinal) {
            boolean valid = true;
            for (int val : current) {
                if (val > k && val != maxVal) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ops++;
                for (int j = 0; j < current.length; j++) {
                    current[j] = Math.min(current[j], k);
                }
            }
        }

        for (int val : current) {
            if (val != k) return -1;
        }

        return ops;
    }
}
