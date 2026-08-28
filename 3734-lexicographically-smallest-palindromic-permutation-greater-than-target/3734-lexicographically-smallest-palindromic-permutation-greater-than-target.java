class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] totalCount = new int[26];
        for (int i = 0; i < n; i++) {
            totalCount[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        int oddChar = -1;
        for (int i = 0; i < 26; i++) {
            if (totalCount[i] % 2 != 0) {
                oddCount++;
                oddChar = i;
            }
        }

        if ((n % 2 == 0 && oddCount > 0) || (n % 2 == 1 && oddCount != 1)) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = totalCount[i] / 2;
        }

        int[] curHalfCount = halfCount.clone();
        boolean canMatchExact = true;
        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';
            if (curHalfCount[c] > 0) {
                curHalfCount[c]--;
            } else {
                canMatchExact = false;
                break;
            }
        }

        if (canMatchExact) {
            String exactCandidate = buildPalindrome(target.substring(0, halfLen), oddChar, n);
            if (exactCandidate.compareTo(target) > 0) {
                return exactCandidate;
            }
        }

        for (int i = halfLen - 1; i >= 0; i--) {
            int[] available = halfCount.clone();
            boolean prefixValid = true;
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (available[c] > 0) {
                    available[c]--;
                } else {
                    prefixValid = false;
                    break;
                }
            }
            if (!prefixValid) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (available[c] > 0) {
                    available[c]--;

                    StringBuilder firstHalf = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        firstHalf.append(target.charAt(j));
                    }
                    firstHalf.append((char) ('a' + c));

                    for (int k = 0; k < 26; k++) {
                        while (available[k] > 0) {
                            firstHalf.append((char) ('a' + k));
                            available[k]--;
                        }
                    }

                    return buildPalindrome(firstHalf.toString(), oddChar, n);
                }
            }
        }

        return "";
    }

    private String buildPalindrome(String firstHalf, int oddChar, int totalLen) {
        StringBuilder sb = new StringBuilder(firstHalf);
        if (totalLen % 2 == 1) {
            sb.append((char) ('a' + oddChar));
        }
        for (int i = firstHalf.length() - 1; i >= 0; i--) {
            sb.append(firstHalf.charAt(i));
        }
        return sb.toString();
    }
}