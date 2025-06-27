import java.util.*;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        List<Character> candidates = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                candidates.add((char)(i + 'a'));
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        String result = "";
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char c : candidates) {
                String next = curr + c;
                if (isRepeatedSubsequence(s, next, k)) {
                    result = next;
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isRepeatedSubsequence(String s, String pattern, int k) {
        int i = 0, j = 0, count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == pattern.charAt(j)) {
                j++;
                if (j == pattern.length()) {
                    count++;
                    if (count == k) return true;
                    j = 0;
                }
            }
            i++;
        }
        return false;
    }
}
