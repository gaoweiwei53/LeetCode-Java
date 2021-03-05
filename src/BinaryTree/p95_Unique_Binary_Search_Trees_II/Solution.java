package p95_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    // 回溯法？不就是递归吗
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    //递归
    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (n == 0) {
            return ans;
        }
        return getAns(1, n);

    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            ans.add(null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = getAns(start, i - 1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    // 动态规划
    public List<TreeNode> generateTrees3(int n) {
        List<TreeNode>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList(); // 如果left或right为0，就会出现空指针异常。
        if (n == 0) return dp[0];
        dp[0].add(null);// 如果不加null，那么后面当left或right为0时，就不会执行for循环。而一旦left不执行，right也会被跳过。
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList();
            for (int root = 1; root <= i; root++) {
                int left = root - 1; // root为根节点，left是root左边的节点数。
                int right = i - root;// 同理，right为root右边的节点数。
                /*
                    假设n为5，root是3，那么左边有2个节点，所以去dp[2]里面找，右边也有两个节点4,5。所以还去dp[2]里面找。
                    因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2，我们要的是4,5。
                    我们不妨将1,2加上root，你会发现正好是4,5。
                    所以得到结论，左子树的值直接找前面节点数一样的dp索引，右子树的值也找前面一样的dp索引,
                    但是你需要加上root才能保证val是你需要的，所以右子树要重新创建，不然会破坏前面的树。
                */
                // 如果dp[left]里有两种可能，dp[right]里有三种可能，那么总共有6种可能。
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode newRoot = new TreeNode(root); // 这个是每一种可能的root节点。
                        newRoot.left = leftTree; // 左子树直接连接。
                        newRoot.right = clone(root, rightTree); // 右子树创建一个新的树。
                        dp[i].add(newRoot); // 将一种可能加入dp中。
                    }
                }
            }
        }
        return dp[n]; // 这个不用多说，答案在第n个数上。
    }

    public TreeNode clone(int val, TreeNode root) { // 重新创建一个新的子树
        if (root == null) return null; // 如果为null，返回
        TreeNode newTree = new TreeNode(val + root.val); // 创建节点时，不要忘了还要加上那个root。
        newTree.left = clone(val, root.left); // 递归左和右，和先序遍历很像。
        newTree.right = clone(val, root.right);
        return newTree; // 返回回去的这个节点正好跟在你需要的右子树上。
    }
}
