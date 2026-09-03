class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minOdd = Integer.MAX_VALUE;
        int oddCount = 0;

        for (int x : nums1) {
            if (x % 2 != 0) {
                oddCount++;
                if (x < minOdd) {
                    minOdd = x;
                }
            }
        }

        if (oddCount == 0 || oddCount == n) {
            return true;
        }

        for (int x : nums1) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}