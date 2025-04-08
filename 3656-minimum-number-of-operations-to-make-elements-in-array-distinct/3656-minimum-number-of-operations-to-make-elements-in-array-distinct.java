import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        for (int ops = 0; ops * 3 <= n; ops++) {
            Set<Integer> seen = new HashSet<>();
            boolean duplicate = false;
            for (int i = ops * 3; i < n; i++) {
                if (!seen.add(nums[i])) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) return ops;
        }
        return (n + 2) / 3;
    }
}
