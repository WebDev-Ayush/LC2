import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int result = 0;
        for (String word : set) {
            result += word.length() + 1;
        }
        return result;
    }
}