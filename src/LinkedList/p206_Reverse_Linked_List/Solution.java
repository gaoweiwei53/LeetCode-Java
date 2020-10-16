package p206_Reverse_Linked_List;

public class Solution {
    public ListNode reverseList(ListNode head) {
        // 双指针解法
        ListNode curr = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = curr;
            curr = pre;
            pre = tmp;
        }
        return curr;


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
