package problem.easy.Path_Sum;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return false;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.add(curr.left);
                curr.left.val += curr.val;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                curr.right.val += curr.val;
            }

            if(curr.left == null && curr.right == null && curr.val == targetSum) return true;
        }

        return false;
    }
}