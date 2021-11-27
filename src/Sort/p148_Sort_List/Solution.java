package p148_Sort_List;


/*
* 要求: 时间复杂度为O(nlogn)
*      空间复杂度为O(1)
* */

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Solution {
    // 自底向上的归并排序 空间复杂度为 O(1)
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 1. 确定链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        // subLength 表示每次需要排序的子链表的长度
        // 2. 每次将链表拆分成若干个长度为subLength 的子链表
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            // curr用于记录拆分链表的位置
            while (curr != null) {
                // 第一个链表的头 即 curr初始的位置
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 第二个链表的头  即 链表1尾部的下一个位置
                ListNode head2 = curr.next;
                // 断开第一个链表和第二个链表的链接
                curr.next = null;
                // 第二个链表头 重新赋值给curr
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 保存后面的节点
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }
            else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

//    public ListNode merge(ListNode head1, ListNode head2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
//        while (temp1 != null && temp2 != null) {
//            if (temp1.val <= temp2.val) {
//                temp.next = temp1;
//                temp1 = temp1.next;
//            } else {
//                temp.next = temp2;
//                temp2 = temp2.next;
//            }
//            temp = temp.next;
//        }
//        if (temp1 != null) {
//            temp.next = temp1;
//        } else if (temp2 != null) {
//            temp.next = temp2;
//        }
//        return dummyHead.next;
//    }

    // 自上向底的归并排序 递归，空间复杂度为O(log n)
    public ListNode sortList2(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 1. 找到链表的中心节点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        // 2. 递归调用排序
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        // 3. 合并链表
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public static void main(String[] args) {
        int a = 1;
        for (int i = 1; i < 20; i <<= 1) {
            System.out.print(i + " ");

        }
    }
    // 递归 从顶至底
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
class Solution2 {
    public ListNode sortList(ListNode head) {
        //边界
        if(head==null||head.next==null) return head;
        //伪头结点
        ListNode pre=new ListNode(0,head);
        //快排
        quickSort(pre,null);
        //返回头结点
        return pre.next;
    }
    //输入时伪头结点和尾节点null
    void quickSort(ListNode pre,ListNode end){
        //如果节点数小于1就返回
        if(pre==end||pre.next==end||pre.next.next==end) return;
        //选第一个节点为基准
        ListNode b=pre.next;
        //建立临时链表
        ListNode cur=new ListNode(0);
        //临时左右两指针
        ListNode r=b,l=cur;
        //遍历，右指针下一节点为end，说明当前是最后一个元素，结束
        while(r.next!=end){
            //如果当前元素小于基准，就加入临时链表，并在原链表中删除
            if(r.next.val<b.val){
                l.next=r.next;
                l=l.next;
                r.next=r.next.next;
            } else{
                //不小于基准，右指针后移
                r=r.next;
            }
        }
        //临时链表接在原链表前面，并把伪头结点指向临时节点头结点
        l.next=pre.next;
        pre.next=cur.next;
        //对基准的左右两边递归，注意输入都是伪头结点和两链表的尾节点的下一节点
        quickSort(pre,b);
        quickSort(b,end);
    }
}

/*
时间复杂度是O(nlogn) 的排序算法包括归并排序、堆排序和快速排序（快速排序的最差时间复杂度是 O(n^2)），其中最适合链表的排序算法是归并排序。
归并排序基于分治算法。最容易想到的实现方式是自顶向下的递归实现，考虑到递归调用的栈空间，自顶向下归并排序的空间复杂度是O(logn)。
如果要达到 O(1)的空间复杂度，则需要使用自底向上的实现方式。
*/
