import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int[] t1Reach = new int[n];
        int[] t2Reach = new int[m];

        for (int i = 0; i < n; i++) {
            t1Reach[i] = bfsCount(tree1, i, k);
        }

        for (int j = 0; j < m; j++) {
            t2Reach[j] = bfsCount(tree2, j, k - 1);
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int maxTargets = t1Reach[i];
            for (int j = 0; j < m; j++) {
                maxTargets = Math.max(maxTargets, t1Reach[i] + t2Reach[j]);
            }
            answer[i] = maxTargets;
        }

        return answer;
    }

    private List<List<Integer>> buildTree(int nodes, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        return tree;
    }

    private int bfsCount(List<List<Integer>> tree, int start, int maxDepth) {
        int count = 0;
        boolean[] visited = new boolean[tree.size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], depth = current[1];
            if (depth > maxDepth) continue;
            count++;
            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }

        return count;
    }
}
