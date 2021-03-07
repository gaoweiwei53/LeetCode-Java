package p107_Binary_Tree_Level_Order_Traversal_II;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (root == null) return res;
        while(!queue.isEmpty()){
            // 这一句要注意
            int n = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
            //或者每次加到结果集的前面
//            res.add(0,list);
        }
        Collections.reverse(res);
        return res;

        //错误示例
/*          List<List<Integer>>  res = new ArrayList<>();
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
          if (root == null) return res;
          while(queue.size() != 0){
              List<Integer> list = new LinkedList<>();
              for (int i = 0; i < queue.size(); i++) {
                   TreeNode node = queue.poll();
                   if (node.left != null){
                       queue.offer(node.left);
                   }
                   if (node.right != null){
                       queue.offer(node.right);
                   }
                   list.add(node.val);
              }
              res.add(list);
          }
          Collections.reverse(res);
          return res;*/
    }
}
