package p160_Intersection_of_Two_Linked_Lists;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 写法1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            if (pA == null) pA = headB;
            else pA = pA.next;

            if (pB == null) pB = headA;
            else pB = pB.next;
        }
        return pA;

    }

    // 写法2
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    // 我的写法 垃圾
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(a == null){
            a = headB;
        }
        else{
            b = headA;
        }
        while(a != null && b != null){
            a = a.next;
            b = b.next;
        }
        if(a == null){
            a = headB;
        }
        else{
            b = headA;
        }
        while(a != null && b != null){
            if(a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }


}
