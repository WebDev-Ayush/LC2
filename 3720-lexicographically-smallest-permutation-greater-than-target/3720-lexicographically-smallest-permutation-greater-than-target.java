class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[] prefixCount = count.clone();
        int validPrefixLen = 0;

        while (validPrefixLen < n) {
            int ch = target.charAt(validPrefixLen) - 'a';
            if (prefixCount[ch] > 0) {
                prefixCount[ch]--;
                validPrefixLen++;
            } else {
                break;
            }
        }

        for (int i = validPrefixLen; i >= 0; i--) {
            int[] remaining = count.clone();
            for (int j = 0; j < i; j++) {
                remaining[target.charAt(j) - 'a']--;
            }

            if (i < n) {
                int targetChar = target.charAt(i) - 'a';
                for (int nextChar = targetChar + 1; nextChar < 26; nextChar++) {
                    if (remaining[nextChar] > 0) {
                        remaining[nextChar]--;

                        StringBuilder sb = new StringBuilder();
                        sb.append(target, 0, i);
                        sb.append((char) ('a' + nextChar));

                        for (int remChar = 0; remChar < 26; remChar++) {
                            while (remaining[remChar] > 0) {
                                sb.append((char) ('a' + remChar));
                                remaining[remChar]--;
                            }
                        }

                        return sb.toString();
                    }
                }
            }
        }

        return "";
    }
}