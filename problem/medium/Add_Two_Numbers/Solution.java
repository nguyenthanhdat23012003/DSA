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
        // // Solution 1: Combine numbers and then add -> not work with contraint, overflow.
        // int l1Num = 0, l2Num = 0;
        // int stepTime = 1;

        // while(l1 != null){
        //     l1Num += l1.val * stepTime;
        //     stepTime *= 10;
        //     l1 = l1.next;
        // }

        // stepTime = 1;

        // while(l2 != null){
        //     l2Num += l2.val * stepTime;
        //     stepTime *= 10;
        //     l2 = l2.next;
        // }

        // int resultInt = l1Num + l2Num;

        // if(resultInt == 0) return new ListNode(0);

        // ListNode dummyResult = new ListNode(0);
        // ListNode stored = dummyResult;

        // while(resultInt != 0){
        //     stored.next = new ListNode(resultInt % 10);
        //     resultInt = resultInt / 10;
        //     stored = stored.next;
        // }

        // return dummyResult.next;

        // Solution 2: Add each node to one
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}