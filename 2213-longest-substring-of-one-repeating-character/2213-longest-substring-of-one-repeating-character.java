class Solution {
    static class Node {
        char leftChar, rightChar;
        int prefixLen, suffixLen, maxLen;
        int size;

        Node(char c) {
            this.leftChar = c;
            this.rightChar = c;
            this.prefixLen = 1;
            this.suffixLen = 1;
            this.maxLen = 1;
            this.size = 1;
        }

        Node() {}
    }

    private Node[] tree;
    private char[] sChars;

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;
        res.size = left.size + right.size;

        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(res.maxLen, left.suffixLen + right.prefixLen);
        }

        res.prefixLen = left.prefixLen;
        if (left.prefixLen == left.size && left.rightChar == right.leftChar) {
            res.prefixLen += right.prefixLen;
        }

        res.suffixLen = right.suffixLen;
        if (right.suffixLen == right.size && right.leftChar == left.rightChar) {
            res.suffixLen += left.suffixLen;
        }

        return res;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(sChars[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            tree[node] = new Node(val);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        sChars = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);

            sChars[idx] = c;
            update(1, 0, n - 1, idx, c);

            result[i] = tree[1].maxLen;
        }

        return result;
    }
}