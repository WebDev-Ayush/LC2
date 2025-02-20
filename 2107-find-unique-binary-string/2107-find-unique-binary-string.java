import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        return backtrack("", set, nums[0].length());
    }

    private String backtrack(String current, Set<String> set, int n) {
        if (current.length() == n) {
            if (!set.contains(current)) {
                return current;
            }
            return "";
        }

        String result = backtrack(current + "0", set, n);
        if (!result.isEmpty()) {
            return result;
        }

        result = backtrack(current + "1", set, n);
        return result;
    }
}