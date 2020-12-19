package p61_Rotate_List;

class Solution {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){ this.val = val;};
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newhead, p;
        int n = 1;
        p = head;
        while (p.next != null){
            p = p.next;
            n++;
        }
        p.next = head;
        p = head;
        for (int i = 0; i < n - k % n - 1; i++){
            p = p.next;
        }
        newhead = p.next;
        p.next = null;
        return newhead;


//        // base cases
//        if (head == null) return null;
//        if (head.next == null) return head;
//
//        // close the linked list into the ring
//        ListNode old_tail = head;
//        int n;
//        for(n = 1; old_tail.next != null; n++)
//            old_tail = old_tail.next;
//        old_tail.next = head;
//
//        // find new tail : (n - k % n - 1)th node
//        // and new head : (n - k % n)th node
//        ListNode new_tail = head;
//        for (int i = 0; i < n - k % n - 1; i++)
//            new_tail = new_tail.next;
//        ListNode new_head = new_tail.next;
//
//        // break the ring
//        new_tail.next = null;
//
//        return new_head;
    }
}