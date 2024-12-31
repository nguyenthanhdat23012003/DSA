package problem.medium.Reverse_Linked_List_II;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode beforeLeft = dummy;

        for(int i = 0; i < left - 1; i++){
            beforeLeft = beforeLeft.next;
        }

        ListNode prev = null;
        ListNode curr = beforeLeft.next;
        ListNode tail = curr;

        for(int i = 0; i <= right - left; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        beforeLeft.next = prev;
        tail.next = curr;

        return dummy.next;
    }
}