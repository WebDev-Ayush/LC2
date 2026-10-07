import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, '(', ')');
        return ans;
    }

    private void remove(String s, List<String> ans, int lastI, int lastJ, char open, char close) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == open) count++;
            if (s.charAt(i) == close) count--;
            if (count >= 0) continue;

            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == close && (j == lastJ || s.charAt(j - 1) != close)) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, open, close);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (open == '(') {
            remove(reversed, ans, 0, 0, ')', '(');
        } else {
            ans.add(reversed);
        }
    }
}