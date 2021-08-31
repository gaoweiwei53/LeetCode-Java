package p112_Path_Sum;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
          // 更简洁
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);

    }




    public boolean hasPathSum2(TreeNode root, int targetSum) {

        int sum = 0;
        return dfs(root,targetSum,sum);

    }

    private boolean dfs(TreeNode root, int targetSum, int sum) {
          if (root==null) return false;
          sum += root.val;
          if (root.left == null && root.right == null){
              if (sum == targetSum)
                  return true;
              else
                  return false;
          }
          else if (root.left == null)
              return dfs(root.right, targetSum, sum);
          else if (root.right == null)
              return dfs(root.left, targetSum, sum);
          else
              return dfs(root.left, targetSum, sum) || dfs(root.right, targetSum, sum);
    }
}