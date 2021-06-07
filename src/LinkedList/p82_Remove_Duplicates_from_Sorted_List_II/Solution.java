package p82_Remove_Duplicates_from_Sorted_List_II;


  //Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                int tmp = curr.val;
                while(curr != null && curr.val == tmp){
                    curr = curr.next;
                }
                pre.next = curr;
            }
            else {
                pre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
