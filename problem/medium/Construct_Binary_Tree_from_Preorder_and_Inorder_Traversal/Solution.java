package problem.medium.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIdxIn = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == rootVal) rootIdxIn = i;
        }

        int leftSizeSubTree = rootIdxIn - inStart;

        root.left = buildTreeHelper(preorder, inorder, preStart + 1, preEnd + leftSizeSubTree, inStart, rootIdxIn - 1);

        root.right = buildTreeHelper(preorder, inorder, preStart + 1 + leftSizeSubTree, preEnd, rootIdxIn + 1, inEnd);

        return root;
    }
}