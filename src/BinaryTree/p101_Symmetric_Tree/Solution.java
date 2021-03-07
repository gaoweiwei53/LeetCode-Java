package p101_Symmetric_Tree;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 为什么不对 32 行错误
/*
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);

    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) return true;
        return isSymmetric(left.left, right.left) && isSymmetric(left.right, right.right);

    }
*/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);

    }
    // 为什么这样更快呢
/*    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }*/
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        // 节点为空的情况, 终止条件
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        // 节点不为空的情况，必须是不等于，如果是等于那么只要要有相等的值就停止搜索了
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }



}
