package p106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
      public class TreeNode {
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
    private Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree(postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int in_left, int in_right, int po_left, int po_right) {
        // 这一句很重，递归的终止条件！
        if (po_left > po_right) return null;
        int i = indexMap.get(postorder[po_right]);
         TreeNode root = new TreeNode(postorder[po_right]);
         int right_len = in_right - i;
         root.left = buildTree(postorder, in_left,i-1, po_left, po_right - right_len - 1);
         root.right = buildTree(postorder, i+1, in_right,po_right - right_len, po_right - 1);
         return root;
    }
}
