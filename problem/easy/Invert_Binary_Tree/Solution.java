package problem.easy.Invert_Binary_Tree;


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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        root.right = invertTree(root.right);
        root.left = invertTree(root.left);
        return root;
    }
}