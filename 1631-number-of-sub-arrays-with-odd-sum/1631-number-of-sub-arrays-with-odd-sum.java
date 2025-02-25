public class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0;
        int evenCount = 1;
        int currentSum = 0;
        int result = 0;

        for (int num : arr) {
            currentSum += num;
            if (currentSum % 2 == 1) {
                result += evenCount;
                oddCount++;
            } else {
                result += oddCount;
                evenCount++;
            }
            result %= MOD;
        }

        return result;
    }
}
