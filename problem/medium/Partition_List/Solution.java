package problem.medium.Partition_List;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr != null && curr.val < x) {
            prev = curr;
            curr = curr.next;
        }
        ListNode next = curr;
        ListNode prevCurr = curr;
        if(curr == null) return head;
        curr = curr.next;

        while(curr != null) {
            if(curr.val < x){
                prevCurr.next = curr.next;
                curr.next = next;
                prev.next = curr;
                prev = curr;
                curr = prevCurr.next;
            } else {
                prevCurr = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}