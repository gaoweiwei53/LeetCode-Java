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
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;

        // 递归
        if (head == null || head.next == null) {
            // 若是最后一个节点，则返回本身
            return head;
        }
        ListNode p = reverseList(head.next);
        // 每次函数在返回的过程中，让当前结点的下一个结点的 nextnext 指针指向当前节点。
        head.next.next = head;
        head.next = null;
        return p;
    }

}
