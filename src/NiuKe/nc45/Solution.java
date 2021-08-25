package nc45;

import java.util.*;

  class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }

public class Solution {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        preorder(root, list1);
        Inorder(root, list2);
        postorder(root, list3);
        int[][] res = new int[3][list1.size()];
        for(int i = 0; i < list1.size(); i++){
            res[0][i] = list1.get(i);
            res[1][i] = list2.get(i);
            res[2][i] = list3.get(i);
        }
        return res;
    }
    private void preorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
    private void Inorder(TreeNode root, List<Integer> list){
        if(root == null) return;

        Inorder(root.left, list);
        list.add(root.val);
        Inorder(root.right, list);
    }
    private void postorder(TreeNode root, List<Integer> list){
        if(root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }
}