package p109_Convert_Sorted_List_to_Binary_Search_Tree;


//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 快慢指针找中心节点
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;

        // 以升序链表的中间元素作为根节点 root，递归的构建 root 的左子树与右子树。
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }

    // 可太难理解了
/*    ListNode ptr;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        if(head.next == null) return new TreeNode(head.val);

        ptr = head;
        return buildTree(0, length(head) - 1);
    }

    TreeNode buildTree(int left, int right){
        if(left > right) return null;
        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode();

        TreeNode leftTree = buildTree(left, mid - 1);

        root.val = ptr.val;
        ptr = ptr.next;
        root.left = leftTree;
        root.right = buildTree(mid + 1, right);
        return root;
    }
    int length(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }*/
}
