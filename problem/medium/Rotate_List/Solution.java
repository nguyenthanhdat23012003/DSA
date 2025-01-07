package problem.medium.Rotate_List;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode curr = head;
        int count = 1;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }

        int realStep = k % count;

        int lastIdx = count - realStep;
        curr.next = head;

        while(lastIdx > 0){
            curr = curr.next;
            lastIdx--;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}