package p2_Add_Two_Numbers;

class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head =  new ListNode(-1);
        ListNode p = head;
        boolean carry = false;
        int sum = 0;
        while (l1 != null || l2 != null){
            sum = 0;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            if (carry)
                sum++;
            p.next = new ListNode(sum%10);
            p = p.next;
            carry = sum >= 10?true:false;
        }
        if (carry){
            p.next =new ListNode(1);
        }
        return head.next;
    }
}