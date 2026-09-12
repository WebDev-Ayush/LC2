class Solution {
    static class Interval {
        int l, r, w, id;
        Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }
    }

    static class State {
        long weight;
        List<Integer> ids;

        State(long weight, List<Integer> ids) {
            this.weight = weight;
            this.ids = ids;
        }

        static State better(State a, State b) {
            if (a == null) return b;
            if (b == null) return a;
            if (a.weight != b.weight) {
                return a.weight > b.weight ? a : b;
            }
            int len = Math.min(a.ids.size(), b.ids.size());
            for (int i = 0; i < len; i++) {
                if (!a.ids.get(i).equals(b.ids.get(i))) {
                    return a.ids.get(i) < b.ids.get(i) ? a : b;
                }
            }
            return a.ids.size() <= b.ids.size() ? a : b;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> iv = intervals.get(i);
            arr[i] = new Interval(iv.get(0), iv.get(1), iv.get(2), i);
        }

        Arrays.sort(arr, (a, b) -> a.r != b.r ? Integer.compare(a.r, b.r) : Integer.compare(a.l, b.l));

        State[][] dp = new State[5][n + 1];
        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                dp[k][i] = new State(0, new ArrayList<>());
            }
        }

        for (int i = 1; i <= n; i++) {
            Interval cur = arr[i - 1];

            int low = 0, high = i - 2, p = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid].r < cur.l) {
                    p = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            for (int k = 1; k <= 4; k++) {
                dp[k][i] = dp[k][i - 1];

                State prev = (p != -1) ? dp[k - 1][p + 1] : dp[k - 1][0];
                long newWeight = prev.weight + cur.w;

                List<Integer> newIds = new ArrayList<>(prev.ids);
                newIds.add(cur.id);
                Collections.sort(newIds);

                State candidate = new State(newWeight, newIds);
                dp[k][i] = State.better(dp[k][i], candidate);
            }
        }

        State best = dp[0][n];
        for (int k = 1; k <= 4; k++) {
            best = State.better(best, dp[k][n]);
        }

        int[] result = new int[best.ids.size()];
        for (int i = 0; i < best.ids.size(); i++) {
            result[i] = best.ids.get(i);
        }
        return result;
    }
}