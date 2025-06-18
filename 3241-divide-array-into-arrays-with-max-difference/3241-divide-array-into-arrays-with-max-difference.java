import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        boolean[] used = new boolean[n];
        int[][] result = new int[n / 3][3];
        int groupCount = 0;

        for (int i = 0; i < n;) {
            if (used[i]) {
                i++;
                continue;
            }

            List<Integer> group = new ArrayList<>();
            group.add(nums[i]);
            used[i] = true;

            for (int j = i + 1; j < n && group.size() < 3; j++) {
                if (!used[j] && nums[j] - group.get(0) <= k) {
                    group.add(nums[j]);
                    used[j] = true;
                }
            }

            if (group.size() != 3) {
                return new int[0][0];
            }

            for (int x = 0; x < 3; x++) {
                result[groupCount][x] = group.get(x);
            }
            groupCount++;
        }

        return result;
    }
}
