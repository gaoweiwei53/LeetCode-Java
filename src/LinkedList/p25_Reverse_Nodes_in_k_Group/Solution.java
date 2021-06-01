package p25_Reverse_Nodes_in_k_Group;

  //Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            // 每次遍历到该组的最后一个节点
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            // 如果最后一组节点的个数不足k
            if (end == null) break;

            ListNode start = pre.next;
            // next指向下一组的第一个节点
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            // 反转之后start指向的是当前组的最后一个节点
            start.next = next;
            pre = start;
            // 最后将pre指向当前组的最后一个节点
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
