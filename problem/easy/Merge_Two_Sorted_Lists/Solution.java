package problem.easy.Merge_Two_Sorted_Lists;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // // Solution 1: Iterative
        // // Time Complexity: O(m + n)
        // // Space Complexity: O(1)
        // ListNode dummyResult = new ListNode(0);
        // ListNode current = dummyResult;
        // while(list1 != null && list2 != null){
        //     if(list1.val <= list2.val){
        //         current.next = list1;
        //         list1 = list1.next;
        //     } else {
        //         current.next = list2;
        //         list2 = list2.next;
        //     }
        //     current = current.next;
        // }
        // if(list1 != null) current.next = list1;
        // if(list2 != null) current.next = list2;

        // return dummyResult.next;

        // Solution 2: Recursion
        // Time Complexity: O(m + n)
        // Space Complexity: O(m + n)
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}