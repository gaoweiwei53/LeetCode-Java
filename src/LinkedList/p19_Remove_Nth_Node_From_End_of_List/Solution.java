package LinkedList.p19_Remove_Nth_Node_From_End_of_List;

public class Solution {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummyNode = new ListNode(0, head);
//        ListNode pA = dummyNode;
//        ListNode pB = dummyNode;
//        if (head == null) return null;
//        for(int i = 0; i < n - 1; i++) pA = pA.next;
//        while(pA != null){
//            pA = pA.next;
//            pB = pB.next;
//        }
//        pB.next = pB.next.next;
//        return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }


}
