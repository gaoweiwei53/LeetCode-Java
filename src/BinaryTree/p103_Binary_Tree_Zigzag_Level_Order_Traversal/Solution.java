package p103_Binary_Tree_Zigzag_Level_Order_Traversal;

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
    // 建议使用
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        // 速度很快
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        List<Integer> list ;
        while (!queue.isEmpty()) {
            int size = queue.size(); //当前层，元素的数量
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); //按顺序弹出队列元素，加入集合
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left); //当前元素的左子树入队，即把下一层的元素加入队列
                }
                if (node.right != null) {
                    queue.offer(node.right); //当前元素的右子树入队，即把下一层的元素加入队列
                }
            }
            if (res.size() % 2 == 1) { //本题中奇数层要翻转下
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 使用双端队列，比较慢，使用逆序试试？
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                // 取
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }




/*        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        int l = 1;
        while (!queue.isEmpty()) {
            // n 每层节点的数量，用来作为后面遍历的次数，目的是每次把每层的结点从队列中取完
            int n = queue.size();
            // level 保存每层的节点
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // poll 取出节点，不抛出异常
                TreeNode node = queue.poll();
                level.add(node.val);
                if (l % 2 == 0){
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                else {
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                }

            }
            res.add(level);
            l++;
        }

        return res;*/

}
