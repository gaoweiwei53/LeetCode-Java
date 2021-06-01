package p92_Reverse_Linked_List2;


import java.util.ArrayList;
import java.util.List;

class Solution {
//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if(head == null) {
//            return head;
//        }
//        List<Integer> list = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null) {
//            list.add(cur.val); //所有元素放入集合
//            cur = cur.next;
//        }
//        int i = m - 1; //注意索引要减一，因为集合从0开始
//        int j = n - 1;
//        while (i < j) { //交换m到n的元素
//            int temp = list.get(i);
//            list.set(i, list.get(j));
//            list.set(j, temp);
//            i++;
//            j--;
//        }
//        ListNode dumy = new ListNode(0);
//        ListNode res = dumy;
//        for (int k = 0; k < list.size(); k++) {
//            dumy.next = new ListNode(list.get(k)); //重新串节点
//            dumy = dumy.next;
//        }
//        return res.next;
        // 递归
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
    // 头插法
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}