package problem.medium.Add_Two_Numbers;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Solution 1: Combine numbers and then add -> not work with contraint, overflow.
        int l1Num = 0, l2Num = 0;
        int stepTime = 1;

        while(l1 != null){
            l1Num += l1.val * stepTime;
            stepTime *= 10;
            l1 = l1.next;
        }

        stepTime = 1;

        while(l2 != null){
            l2Num += l2.val * stepTime;
            stepTime *= 10;
            l2 = l2.next;
        }

        int resultInt = l1Num + l2Num;

        if(resultInt == 0) return new ListNode(0);

        ListNode dummyResult = new ListNode(0);
        ListNode stored = dummyResult;

        while(resultInt != 0){
            stored.next = new ListNode(resultInt % 10);
            resultInt = resultInt / 10;
            stored = stored.next;
        }

        return dummyResult.next;
    }
}