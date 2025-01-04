package problem.medium.Remove_Nth_Node_From_End_of_List;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        int countNum = 0;
        while(curr.next != null){
            countNum++;
            curr = curr.next;
        }

        int idxToRemove = countNum - n;
        curr = dummy;
        while(idxToRemove > 0) {
            curr = curr.next;
            idxToRemove--;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }
}