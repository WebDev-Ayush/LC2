class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            this.cnt = new int[k];
        }
    }

    private int n;
    private int k;
    private Node[] tree;

    private Node merge(Node left, Node right) {
        Node res = new Node(k);
        res.prod = (int) ((1L * left.prod * right.prod) % k);

        for (int r = 0; r < k; r++) {
            res.cnt[r] += left.cnt[r];
        }

        for (int r = 0; r < k; r++) {
            if (right.cnt[r] > 0) {
                int newR = (int) ((1L * left.prod * r) % k);
                res.cnt[newR] += right.cnt[r];
            }
        }

        return res;
    }

    private void build(int node, int l, int r, int[] nums) {
        tree[node] = new Node(k);
        if (l == r) {
            int val = nums[l] % k;
            tree[node].prod = val;
            tree[node].cnt[val] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int v = val % k;
            tree[node].prod = v;
            for (int i = 0; i < k; i++) {
                tree[node].cnt[i] = 0;
            }
            tree[node].cnt[v] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private int queryPrefixes(int node, int l, int r, int ql, int qr, int[] runningProd, int targetX) {
        if (ql <= l && r <= qr) {
            int ans = 0;
            for (int rem = 0; rem < k; rem++) {
                if (tree[node].cnt[rem] > 0) {
                    if ((1L * runningProd[0] * rem) % k == targetX) {
                        ans += tree[node].cnt[rem];
                    }
                }
            }
            runningProd[0] = (int) ((1L * runningProd[0] * tree[node].prod) % k);
            return ans;
        }
        int mid = (l + r) / 2;
        int ans = 0;
        if (ql <= mid) {
            ans += queryPrefixes(2 * node, l, mid, ql, qr, runningProd, targetX);
        }
        if (qr > mid) {
            ans += queryPrefixes(2 * node + 1, mid + 1, r, ql, qr, runningProd, targetX);
        }
        return ans;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            int[] runningProd = new int[]{1};
            result[i] = queryPrefixes(1, 0, n - 1, start, n - 1, runningProd, x);
        }

        return result;
    }
}