import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tupleSameProduct(int[] nums) {
        if (nums == null || nums.length < 4) {
            return 0;
        }

        Map<Integer, Integer> productCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        int result = 0;
        for (int count : productCount.values()) {
            if (count >= 2) {
                result += count * (count - 1) * 4;
            }
        }

        return result;
    }
}