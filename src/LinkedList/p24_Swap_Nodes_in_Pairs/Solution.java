package p24_Swap_Nodes_in_Pairs;



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

    // 递归写法  优先用这个
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 迭代写法
    public ListNode swapPairs2(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null && prev.next.next != null) {
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            prev = node1;
        }
        return dummyHead.next;
    }

}
