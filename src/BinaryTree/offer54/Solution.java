package offer54;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root) {
        if(root == null || k == 0) return;
        dfs(root.right);
        k = k - 1;
        if(k == 0) res = root.val;
        dfs(root.left);
    }
}
