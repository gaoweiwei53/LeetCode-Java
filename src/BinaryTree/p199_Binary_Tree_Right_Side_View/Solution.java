package p199_Binary_Tree_Right_Side_View;

import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {
    // 深度优先遍历
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        // 从根节点开始访问，根节点深度是0
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(depth == res.size())
            res.add(root.val);
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
    // 广度优先遍历 保存每层最右边的值
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
             int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                if(i == size - 1)
                    res.add(node.val);
            }
        }
        return res;
    }
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
