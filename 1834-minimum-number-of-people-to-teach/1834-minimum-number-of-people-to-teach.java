import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        List<Set<Integer>> knows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) set.add(lang);
            knows.add(set);
        }

        Set<Integer> need = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            Set<Integer> ku = knows.get(u), kv = knows.get(v);
            boolean ok = false;
            for (int lang : ku) {
                if (kv.contains(lang)) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                need.add(u);
                need.add(v);
            }
        }

        if (need.isEmpty()) return 0;

        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;
            for (int user : need) {
                if (!knows.get(user).contains(lang)) cnt++;
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}
