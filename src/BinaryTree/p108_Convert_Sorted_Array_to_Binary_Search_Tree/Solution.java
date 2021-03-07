package p108_Convert_Sorted_Array_to_Binary_Search_Tree;

public class Solution {
    public class TreeNode {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left_idx, int right_idx) {
        if (left_idx > right_idx) return null;
        // 注意这一句
        //int root_index = (right_idx - left_idx) / 2;
        int root_index = left_idx + (right_idx - left_idx) / 2;
        TreeNode root = new TreeNode(nums[root_index]);
        root.left = sortedArrayToBST(nums, left_idx, root_index - 1);
        root.right = sortedArrayToBST(nums, root_index + 1, right_idx);
        return root;

    }
}
