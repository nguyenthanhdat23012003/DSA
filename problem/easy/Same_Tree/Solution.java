package problem.easy.Same_Tree;


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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null && p == null) return true;

        if(q == null || p == null) return false;
        return (q.val == p.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}