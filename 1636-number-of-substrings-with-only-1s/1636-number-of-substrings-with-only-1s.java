class Solution {
    public int numSub(String s) {
        long mod = 1000000007;
        long c = 0, ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                c++;
                ans = (ans + c) % mod;
            } else {
                c = 0;
            }
        }
        return (int) ans;
    }
}
