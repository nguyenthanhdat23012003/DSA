package problem.medium.Copy_List_with_Random_Pointer;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        // Solution 1: Interleave node
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        curr = head;
        Node dummy = new Node(0);
        Node copyNode = dummy;

        while(curr != null){
            copyNode.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copyNode = copyNode.next;
        }

        return dummy.next;
    }
}