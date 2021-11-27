package p958_Check_Completeness_of_a_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

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
// 我们可以对一颗二叉树进行dfs搜索，如果搜索出的节点编号序列值恰好可以组成一个升序的数组
// 并且编号序列是一个从1开始的无间隔的连续数组，则该二叉树为完全二叉树
public class Solution {

    // n 节点个数，p当前最大节点编号
    int n = 0, p = 0;

    public boolean isCompleteTree(TreeNode root) {
        dfs(root,1);
        return n == p;
    }
    public void dfs(TreeNode root , int k) //k是当前节点编号
    {
        if(root == null) return;  //递归到了叶子节点
        //记录节点数和最大节点编号值
        n++;
        p = Math.max(p,k);
        dfs(root.left,2 * k);
        dfs(root.right,2 * k + 1); //递归左右子树
    }
}
//1、我们从根节点开始搜索，并将根节点编号值设置为1。
//2、然后搜索左子树，并传递其根节点值为2*k。搜索右子树，并传递其根节点值为2*k+1
//3、在递归搜索过程中，记录节点个数n和当前最大节点编号值p。
//4、最后判断最大节点值p和节点数n是否相等，相等则该二叉树是完全二叉树，否则不是

// 广度优先遍历
//一个合法的完全二叉树在广度优先遍历的条件下，null结点是最后被访问到的。
// 但我们对于遍历二叉树过程中访问到的null结点是否是这棵树的最后一个结点是未知的，所以

// 1. 层序遍历这棵树，如果访问到了null结点，把null结点也入队，并且 reachNull 标记为true。
// 2. 如果在reachNull为true的情况下访问到了一个非空结点则其一定不是完全二叉的（这相当于null结点不是
// 最后一个结点，此时的这个非空结点要么在null结点的右边，要么在下一层）。
class Solution2 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean reachNull = false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t == null){
                reachNull = true;
            }
            else {
                if(reachNull) return false;
                q.add(t.left);
                q.add(t.right);
            }
        }
        return true;
    }
}
