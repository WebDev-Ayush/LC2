class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int originalOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') originalOnes++;
        }

        String t = "1" + s + "1";
        
        java.util.List<Integer> blockLens = new java.util.ArrayList<>();
        java.util.List<Character> blockTypes = new java.util.ArrayList<>();

        int i = 0, n = t.length();
        while (i < n) {
            char curr = t.charAt(i);
            int start = i;
            while (i < n && t.charAt(i) == curr) {
                i++;
            }
            blockLens.add(i - start);
            blockTypes.add(curr);
        }

        int maxAns = originalOnes;
        int m = blockLens.size();

        int maxZeroBlock = 0;
        for (int k = 0; k < m; k++) {
            if (blockTypes.get(k) == '0') {
                maxZeroBlock = Math.max(maxZeroBlock, blockLens.get(k));
            }
        }

        for (int k = 1; k < m - 1; k++) {
            if (blockTypes.get(k) == '1') {
                int len1 = blockLens.get(k);
                int left0 = blockLens.get(k - 1);
                int right0 = blockLens.get(k + 1);

                int candidate1 = originalOnes + left0 + right0;
                int candidate2 = originalOnes - len1 + maxZeroBlock;

                maxAns = Math.max(maxAns, Math.max(candidate1, candidate2));
            }
        }

        return maxAns;
    }
}