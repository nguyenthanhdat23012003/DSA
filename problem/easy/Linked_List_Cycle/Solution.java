package problem.easy.Linked_List_Cycle;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        // // Solution 1: HashSet
        // HashSet<ListNode> stored = new HashSet<>();
        // ListNode data = head;
        // while(data != null && data.next != null){
        //     stored.add(data);
        //     data = data.next;
        //     if(stored.contains(data)) return true;
        // }

        // return false;  
        
        
        // Solution 2: Floyd's Cycle Detection Algorithm - Two Pointer
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }

        return false;
    }
}