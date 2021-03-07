package p113_Path_Sum_II;

import java.util.*;

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
    List<List<Integer>> res = new ArrayList<>();
    // 如果Deque作为stack，只能在头进行进出操作，这样最后加入到列表后，顺序为新元素在前，老元素在后，不符合题目要求
    // 所以应该用双端队列，在队列的尾部进行进出操作
    Deque<Integer> queue = new ArrayDeque<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          if (root == null) return res;
          // 从尾部插入
          queue.offerLast(root.val);
          if (root.left == null && root.right == null){
              if (root.val == targetSum){
                  res.add(new ArrayList<>(queue));
              }
          }

          pathSum(root.left, targetSum - root.val);
          pathSum(root.right, targetSum - root.val);
          // 从尾部取出
          queue.pollLast();
          return res;
    }
}
