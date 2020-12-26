package p206_Reverse_Linked_List;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseList(ListNode head) {
//        // 双指针解法
//        if (head == null || head.next == null) return head;
//        ListNode curr = head;
//        ListNode pre = null;
//        while(curr != null){
//            ListNode tmp = curr.next;
//            curr.next  = pre;
//            pre = curr;
//            curr = tmp;
//        }
//        return pre;

        // 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
