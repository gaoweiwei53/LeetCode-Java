package p160_Intersection_of_Two_Linked_Lists;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
//        while (pA != pB) {
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
//        }
//        return pA;
        while (pA != pB){
            if (pA == null) pA = headB;
            else pA = pA.next;

            if (pB == null) pB = headA;
            else pB = pB.next;
        }
        return pA;

    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
