import java.util.*;

class Solution {

    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Step 1: Build mapping
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        // Step 2: Start DFS
        return dfs(bottom);
    }

    private boolean dfs(String curr) {
        // Base case: reached top
        if (curr.length() == 1) return true;

        // Generate all possible next rows
        List<String> nextRows = new ArrayList<>();
        buildNextRow(curr, 0, new StringBuilder(), nextRows);

        // Try each possible next row
        for (String next : nextRows) {
            if (dfs(next)) return true;
        }
        return false;
    }

    private void buildNextRow(String curr, int index, StringBuilder sb, List<String> res) {
        if (index == curr.length() - 1) {
            res.add(sb.toString());
            return;
        }

        String key = curr.substring(index, index + 2);
        if (!map.containsKey(key)) return;

        for (char ch : map.get(key)) {
            sb.append(ch);
            buildNextRow(curr, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
