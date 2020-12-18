package LinkedList.p141_Linked_List_Cycle;


//  Definition for singly-linked list.



public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)   return false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true; // 先移动再判断，避免两个都在head还没移动的情况
        }
        return false; // fast == null || fast.next == null

    }
}