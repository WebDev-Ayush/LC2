import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;

        if (s.length() < totalLength) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int left = i;
            int count = 0;

            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }

                    if (count == totalWords) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    currentCount.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }

        return result;
    }
}