import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int length = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (String word : countMap.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();
            int freq = countMap.get(word);

            if (!word.equals(reversed)) {
                if (countMap.containsKey(reversed)) {
                    int pairCount = Math.min(freq, countMap.get(reversed));
                    length += pairCount * 4;
                    countMap.put(word, countMap.get(word) - pairCount);
                    countMap.put(reversed, countMap.get(reversed) - pairCount);
                }
            } else {
                length += (freq / 2) * 4;
                if (freq % 2 == 1) hasMiddle = true;
            }
        }

        if (hasMiddle) length += 2; 

        return length;
    }
}
