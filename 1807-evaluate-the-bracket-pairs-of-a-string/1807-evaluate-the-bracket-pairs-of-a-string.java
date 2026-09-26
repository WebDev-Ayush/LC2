import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean insideBracket = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                insideBracket = true;
            } else if (c == ')') {
                insideBracket = false;
                result.append(map.getOrDefault(key.toString(), "?"));
                key.setLength(0);
            } else if (insideBracket) {
                key.append(c);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}