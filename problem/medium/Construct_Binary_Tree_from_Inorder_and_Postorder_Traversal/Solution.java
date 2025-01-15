package problem.medium.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost) {
        if(startIn > endIn || startPost > endPost) return null;
        int rootVal = postorder[endPost];
        TreeNode root = new TreeNode(rootVal);

        int rootIdxIn = 0;
        for(int i = startIn; i <= endIn; i++) {
            if(inorder[i] == rootVal) rootIdxIn = i;
        }

        int leftSizeSubTree = rootIdxIn - startIn;

        root.left = buildTreeHelper(
            inorder, postorder,
            startIn, startIn + leftSizeSubTree - 1,
            startPost, startPost + leftSizeSubTree -1
        );
        root.right = buildTreeHelper(
            inorder, postorder,
            rootIdxIn + 1, endIn,
            startPost + leftSizeSubTree, endPost - 1
        );

        return root;
    }
}