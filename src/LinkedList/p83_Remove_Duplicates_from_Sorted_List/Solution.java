package p83_Remove_Duplicates_from_Sorted_List;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {

        // better solution
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    // my solution
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode curr = head.next;
        while(curr != null){
            if(pre.val == curr.val){
                int tmp = pre.val;
                while(curr != null && curr.val == tmp){
                    curr = curr.next;
                }
                pre.next  = curr;
            }
            else{
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
