package LinkedList.p24_Swap_Nodes_in_Pairs;



public class Solution {
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

    // recursion
    public ListNode swapPairs(ListNode head) {
//        ListNode second, lasted;
//        second = head.next;
//        lasted = head.next.next;
//        if (second == null)
//            return head;
//        else if (lasted == null){
//            second.next = head;
//            head.next = null;
//            return second;
//        } else {
//            head.next= swapPairs(lasted);
//            return second;
//        }
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // iteration
    public ListNode swapPairs2(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }
}
