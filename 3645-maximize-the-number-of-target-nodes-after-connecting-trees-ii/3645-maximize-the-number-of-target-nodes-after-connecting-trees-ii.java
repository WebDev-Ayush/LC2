import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildGraph(n, edges1);
        List<List<Integer>> tree2 = buildGraph(m, edges2);

        int[] parity1 = getParityCount(tree1, n);
        int[] parity2 = getParityCount(tree2, m);

        int even1 = parity1[0], odd1 = parity1[1];
        int even2 = parity2[0], odd2 = parity2[1];

        int[] depth1 = getDepths(tree1, n);
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            boolean isEven = (depth1[i] % 2 == 0);
            int option1 = isEven ? even1 + even2 : odd1 + even2;
            int option2 = isEven ? even1 + odd2 : odd1 + odd2;
            res[i] = Math.max(option1, option2);
        }

        return res;
    }

    private List<List<Integer>> buildGraph(int size, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }

    private int[] getDepths(List<List<Integer>> graph, int n) {
        int[] depth = new int[n];
        Arrays.fill(depth, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        depth[0] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : graph.get(node)) {
                if (depth[nei] == -1) {
                    depth[nei] = depth[node] + 1;
                    q.offer(nei);
                }
            }
        }
        return depth;
    }

    private int[] getParityCount(List<List<Integer>> graph, int n) {
        int[] depth = getDepths(graph, n);
        int even = 0, odd = 0;
        for (int d : depth) {
            if (d % 2 == 0) even++;
            else odd++;
        }
        return new int[]{even, odd};
    }
}
