import java.util.Arrays;

public class Solution {
    public static int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int index = 0;
        int[] result = new int[n];

        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }
}