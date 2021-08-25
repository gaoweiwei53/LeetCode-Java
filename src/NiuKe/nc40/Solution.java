package nc40;

import java.util.*;

  class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val){
        this.val = val;
    }
  }

public class Solution {
    /**
     *
     * @param head1 ListNode类 
     * @param head2 ListNode类 
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        ListNode p = head1;
        while(p != null){
            stack1.push(p.val);
            p = p.next;
        }
        p = head2;
        while(p != null){
            stack2.push(p.val);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int tmp  = carry;
            if(!stack1.isEmpty() && !stack2.isEmpty()){
                tmp += stack1.pop() + stack2.pop();
            } else if(stack1.isEmpty() && !stack2.isEmpty()){
                tmp += stack2.pop();
            } else if(!stack1.isEmpty() && stack2.isEmpty()) {
                tmp += stack1.pop();
            }
            ListNode node = new ListNode(tmp % 10);
            node.next = dummy.next;
            dummy.next = node;
            carry = tmp / 10;
        }
        return dummy.next;
    }
}
