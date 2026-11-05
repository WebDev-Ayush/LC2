import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int val : arr1) {
            int idx = Arrays.binarySearch(arr2, val);
            if (idx >= 0) {
                continue;
            }

            int insertPoint = -(idx + 1);
            boolean isValid = true;

            if (insertPoint < arr2.length && Math.abs(arr2[insertPoint] - val) <= d) {
                isValid = false;
            }
            if (insertPoint > 0 && Math.abs(arr2[insertPoint - 1] - val) <= d) {
                isValid = false;
            }

            if (isValid) {
                count++;
            }
        }

        return count;
    }
}