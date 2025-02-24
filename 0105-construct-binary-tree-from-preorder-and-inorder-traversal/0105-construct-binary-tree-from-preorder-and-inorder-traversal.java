public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, Map<Integer, Integer> inorderMap, int preorderIndex, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootVal = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootVal);
        
        int inorderIndex = inorderMap.get(rootVal);
        root.left = buildTreeHelper(preorder, inorderMap, preorderIndex + 1, inorderStart, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderMap, preorderIndex + inorderIndex - inorderStart + 1, inorderIndex + 1, inorderEnd);

        return root;
    }
}
