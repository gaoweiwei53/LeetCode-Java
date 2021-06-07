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
    // 将值复制到数组中再比较
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
}
// 使用双指针
/*
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if(!head || !head->next)
            return 1;
        ListNode *fast = head, *slow = head;
        ListNode *p, *pre = NULL;
        while(fast && fast->next){
            p = slow;
            slow = slow->next;    //快慢遍历
            fast = fast->next->next;

            p->next = pre;  //翻转
            pre = p;
        }
        if(fast)  //奇数个节点时跳过中间节点
            slow = slow->next;

        while(p){       //前半部分和后半部分比较
            if(p->val != slow->val)
                return 0;
            p = p->next;
            slow = slow->next;
        }
        return 1;
    }
};

 */