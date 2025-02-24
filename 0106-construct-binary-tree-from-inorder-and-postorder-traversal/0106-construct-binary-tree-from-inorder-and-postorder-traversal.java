class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, inorderMap, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, 
                                     int postorderIndex, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootVal = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderMap.get(rootVal);
        root.right = buildTreeHelper(inorder, postorder, inorderMap, postorderIndex - 1, inorderIndex + 1, inorderEnd);
        root.left = buildTreeHelper(inorder, postorder, inorderMap, postorderIndex - (inorderEnd - inorderIndex) - 1, inorderStart, inorderIndex - 1);

        return root;
    }
}
