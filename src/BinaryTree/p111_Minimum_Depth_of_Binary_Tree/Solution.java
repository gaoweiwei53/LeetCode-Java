package p111_Minimum_Depth_of_Binary_Tree;

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
    public int minDepth(TreeNode root) {
          if (root == null) return 0;
          if (root.left == null && root.right == null)
            return 1;
          if(root.left == null && root.right != null)
            return minDepth(root.right) + 1;
          if (root.left != null && root.right == null)
            return minDepth(root.left) + 1;
          return Math.min(minDepth(root.left) + 1,minDepth(root.right) + 1);
    }
}
