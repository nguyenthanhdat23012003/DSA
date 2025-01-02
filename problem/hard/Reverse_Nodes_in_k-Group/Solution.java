package problem.hard.Reverse_Nodes_in_k-Group;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;

        ListNode countNode = head;
        int count = 0;
        while(countNode != null){
            countNode = countNode.next;
            count++;
        }

        if(count < k) return head;
        ListNode tail = dummy;

        while(count >= k) {
            ListNode prev = null;
            for(int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode end = tail.next;
            tail.next = prev;
            end.next = curr;
            tail = end;

            count -= k;
        }

        return dummy.next;
    }
}