package problem.easy.Maximum_Depth_of_Binary_Tree;


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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return 1 + Math.max(maxLeft, maxRight);
    }
}