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
    // Solution 1: DFS Recuisive

    // public Node connect(Node root) {
    //     if (root == null) return null;

    //     if (root.left != null) {
    //         root.left.next = (root.right != null) ? root.right : getNextNode(root.next);
    //     }

    //     if (root.right != null) root.right.next = getNextNode(root.next);

    //     connect(root.right);
    //     connect(root.left);

    //     return root;
    // }

    // private Node getNextNode(Node next) {
    //     while(next != null){
    //         if (next.left != null) return next.left;
    //         if (next.right != null) return next.right;
    //         next = next.next;
    //     }

    //     return null;
    // }

    // Solution 2: BFS Iterative
    public Node connect(Node root) {
        if (root == null) return null;

        // Start with the root node
        Node currentLevel = root;

        while (currentLevel != null) {
            Node dummy = new Node(0); // Dummy node to help track the start of the next level
            Node prev = dummy;       // Pointer to connect nodes in the next level
            Node current = currentLevel; // Pointer to traverse the current level

            while (current != null) {
                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }

                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }

                current = current.next; // Move to the next node in the current level
            }

            currentLevel = dummy.next; // Move to the next level
        }

        return root;
    }
}
