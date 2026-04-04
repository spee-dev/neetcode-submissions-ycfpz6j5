class Solution {
    int preIndex = 0;  // global index to track current root in preorder

    int find(int[] inorder, int ele) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == ele) return i;
        }
        return -1;
    }

    TreeNode bTree(int[] preorder, int[] inorder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd) return null;

        // Pick current element from preorder using preIndex and increment preIndex
        int ele = preorder[preIndex++];
        TreeNode root = new TreeNode(ele);

        // If this node has no children, return node
        if (inOrderStart == inOrderEnd) {
            return root;
        }

        // Else find the position of this node in inorder traversal
        int pos = find(inorder, ele);

        // Using index in inorder traversal, construct left and right subtrees
        root.left = bTree(preorder, inorder, inOrderStart, pos - 1);
        root.right = bTree(preorder, inorder, pos + 1, inOrderEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int s = preorder.length;
        return bTree(preorder, inorder, 0, s - 1);
    }
}
