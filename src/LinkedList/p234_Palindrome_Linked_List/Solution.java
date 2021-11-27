package p234_Palindrome_Linked_List;


 // Definition for singly-linked list.


class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = generateMid(head);
        ListNode subHead = reverse(mid);
        //遍历
        while (subHead != null) {
            if (subHead.val != head.val) {
                return false;
            }
            subHead = subHead.next;
            head = head.next;
        }
        return true;
    }
    //反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    //寻找中间节点,或者右中位数节点
    private ListNode generateMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // 方法2: 将值复制到数组中再比较
    public boolean isPalindrome2(ListNode head) {
        ListNode p = head;
        int n = 0;
        while(p != null){
            n++;
            p = p.next;
        }
        int[] arr = new int[n];
        p = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = p.val;
            p = p.next;
        }
        return isPalindrome(arr);
    }

    private boolean isPalindrome(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left < right){
            if(nums[left] != nums[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    // 方法3: 快慢指针寻找中点，同时让前半部分反转，最后比较
    public boolean isPalindrome3(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

}
