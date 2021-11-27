package p39_combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        backtrack(nums, res, path,0, target);
        return res;
    }
    // 可能会出现重复的情况 [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]，怎么办
    // 可先排序，for循环不要从 0 开始, 使用一个 start标识
    // Sum 可不用
    private void backtrack(int[] nums,List<List<Integer>> res, List<Integer> path, int start, int target){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length && target - nums[i] >= 0; i++) {
            path.add(nums[i]);
            backtrack(nums, res, path, i, target - nums[i]);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;

        List<List<Integer>> res = new Solution().combinationSum(nums, target);
        System.out.println(res);
    }

}

