package p83_Remove_Duplicates_from_Sorted_List;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode tmp = head;
        while (p != null){
            if (tmp.val == p.val){
                tmp.next = p.next;
                p = tmp.next;
            }
            else {
                tmp = p;
                p = p.next;
            }
        }
        return head;
// better solution

//        ListNode current = head;
//        while (current != null && current.next != null) {
//            if (current.next.val == current.val) {
//                current.next = current.next.next;
//            } else {
//                current = current.next;
//            }
//        }
//        return head;
    }
}
