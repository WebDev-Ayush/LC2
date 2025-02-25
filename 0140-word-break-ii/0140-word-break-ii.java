import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        dfs(s, wordSet, 0, "", result);
        return result;
    }

    private void dfs(String s, Set<String> wordSet, int start, String current, List<String> result) {
        if (start == s.length()) {
            result.add(current.trim());
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                dfs(s, wordSet, end, current + " " + word, result);
            }
        }
    }
}
