import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        int maxLength = 0;
        Map<String, Integer> dp = new HashMap<>();  // dp[(i, j)] = length of Fibonacci subsequence ending with arr[i] and arr[j]

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int target = arr[j] - arr[i];
                if (target < arr[i] && indexMap.containsKey(target)) {
                    int k = indexMap.get(target);
                    dp.put(i + "," + j, dp.getOrDefault(k + "," + i, 2) + 1);  // Transition to new subsequence
                    maxLength = Math.max(maxLength, dp.get(i + "," + j));
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }
}
