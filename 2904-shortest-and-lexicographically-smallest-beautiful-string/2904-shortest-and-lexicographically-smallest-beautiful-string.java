import java.util.ArrayList;
import java.util.List;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        if (ones.size() < k) {
            return "";
        }

        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= ones.size() - k; i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);
            String sub = s.substring(start, end + 1);

            if (sub.length() < minLen) {
                minLen = sub.length();
                result = sub;
            } else if (sub.length() == minLen && sub.compareTo(result) < 0) {
                result = sub;
            }
        }

        return result;
    }
}