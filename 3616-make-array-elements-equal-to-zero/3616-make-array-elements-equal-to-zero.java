class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (check(nums.clone(), i, 1)) ans++;
                if (check(nums.clone(), i, -1)) ans++;
            }
        }
        return ans;
    }

    boolean check(int[] a, int pos, int dir) {
        int n = a.length;
        while (pos >= 0 && pos < n) {
            if (a[pos] == 0) pos += dir;
            else {
                a[pos]--;
                dir = -dir;
                pos += dir;
            }
        }
        for (int x : a) if (x != 0) return false;
        return true;
    }
}
