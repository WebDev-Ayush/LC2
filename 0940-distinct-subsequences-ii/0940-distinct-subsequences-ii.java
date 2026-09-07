class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long total = 1;
        long[] lastAdded = new long[26];
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            long newSubseq = (total - lastAdded[idx] + MOD) % MOD;
            total = (total + newSubseq) % MOD;
            lastAdded[idx] = (lastAdded[idx] + newSubseq) % MOD;
        }
        
        return (int) ((total - 1 + MOD) % MOD);
    }
}