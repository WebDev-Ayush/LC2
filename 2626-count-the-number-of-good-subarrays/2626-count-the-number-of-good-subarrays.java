import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long res = 0, pairs = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            pairs += count;
            freq.put(val, count + 1);

            while (pairs >= k) {
                res += nums.length - right;
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                pairs -= freq.get(leftVal);
                left++;
            }
        }

        return res;
    }
}
