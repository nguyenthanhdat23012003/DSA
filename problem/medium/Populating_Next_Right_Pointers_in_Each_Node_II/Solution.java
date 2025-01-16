package problem.medium.Populating_Next_Right_Pointers_in_Each_Node_II;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    // Solution 1: Iterative

    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null) {
            root.left.next = (root.right != null) ? root.right : getNextNode(root.next);
        }

        if (root.right != null) root.right.next = getNextNode(root.next);

        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node getNextNode(Node next) {
        while(next != null){
            if (next.left != null) return next.left;
            if (next.right != null) return next.right;
            next = next.next;
        }

        return null;
    }
}
