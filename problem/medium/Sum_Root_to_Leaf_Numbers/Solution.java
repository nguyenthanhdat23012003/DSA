package problem.medium.Sum_Root_to_Leaf_Numbers;

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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.add(curr.left);
                curr.left.val = curr.val * 10 + curr.left.val;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                curr.right.val = curr.val * 10 + curr.right.val;
            }

            if(curr.left == null && curr.right == null) sum += curr.val;
        }

        return sum;
    }
}