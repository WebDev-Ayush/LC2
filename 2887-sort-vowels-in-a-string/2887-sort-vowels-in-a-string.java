import java.util.*;

class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a','e','i','o','u','A','E','I','O','U'
        ));
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) list.add(c);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) sb.append(list.get(idx++));
            else sb.append(c);
        }
        return sb.toString();
    }
}
