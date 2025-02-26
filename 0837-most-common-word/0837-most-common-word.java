import java.util.*;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
        Map<String, Integer> count = new HashMap<>();
        
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
        
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}