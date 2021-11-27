package p105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
class Solution {
    // 效果不错
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, 0, preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int inLeft, int inRight) {
        if(inLeft > inRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);

        int pivotIndex = inorderMap.get(preorder[preLeft]);

        root.left = buildTree(preorder, preLeft+1, inLeft, pivotIndex-1);
        root.right = buildTree(preorder, preLeft+pivotIndex-inLeft+1, pivotIndex+1, inRight);

        return root;
    }
}

class Solution2 {

    private int[] preorder;
    private Map<Integer, Integer> hash;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }
        this.preorder = preorder;
        this.hash = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }


    private TreeNode buildTree(int preLeft, int preRight, int inLeft, int inRight) {
        // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 先序遍历的起点元素很重要
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = hash.get(pivot);
        root.left = buildTree(preLeft + 1, pivotIndex - inLeft + preLeft, inLeft, pivotIndex - 1);
        root.right = buildTree(pivotIndex - inLeft + preLeft + 1, preRight, pivotIndex + 1, inRight);
        return root;
    }
}