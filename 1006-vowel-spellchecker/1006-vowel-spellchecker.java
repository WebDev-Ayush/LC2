import java.util.*;

class Solution {
    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) sb.append('*');
            else sb.append(c);
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> capMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String lower = w.toLowerCase();
            capMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(maskVowels(lower), w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }
            String lower = q.toLowerCase();
            if (capMap.containsKey(lower)) {
                ans[i] = capMap.get(lower);
                continue;
            }
            String masked = maskVowels(lower);
            ans[i] = vowelMap.getOrDefault(masked, "");
        }
        return ans;
    }
}
