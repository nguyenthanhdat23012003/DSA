package problem.medium.Flatten_Binary_Tree_to_Linked_List;

import java.util.Stack;

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
    public void flatten(TreeNode root) {
        // Solution 1: Stack
        // Time Complexity: O(n)
        // Space Complexity: O(h), h is the height of tree

        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if(prev != null) {
                prev.right = curr;
                prev.left = null;
            }

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            prev = curr;
        }

        // Solution 2: Predecessor
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode last = curr.left;
                while(last.right != null) {
                    last = last.right;
                }

                last.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }
}