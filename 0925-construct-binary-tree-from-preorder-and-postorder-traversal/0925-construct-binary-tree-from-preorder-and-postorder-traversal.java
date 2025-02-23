class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> postorderMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postorderMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (postStart == postEnd) {
            return root;
        }
        int postIndex = postorderMap.get(preorder[preIndex]);
        root.left = buildTree(preorder, postorder, postStart, postIndex);
        root.right = buildTree(preorder, postorder, postIndex + 1, postEnd - 1);
        return root;
    }
}