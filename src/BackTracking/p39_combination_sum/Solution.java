package p39_combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;

        List<List<Integer>> res = new Solution().combinationSum(nums, target);
        System.out.println(res);
    }
//    public List<List<Integer>> combinationSum(int[] nums, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<Integer>(), nums, target, 0);
//        return list;
//    }
//    primary
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
//        if(remain < 0) return;
//        else if(remain == 0)
//            list.add(new ArrayList<>(tempList));
//        else{
//            for(int i = start; i < nums.length ; i++){
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }

    //  optimized
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
//        if(remain == 0){
//            list.add(new ArrayList<>(tempList));
//            return;
//        }
//        else{
//            for(int i = start; i < nums.length && nums[i] <= remain; i++){
//                tempList.add(nums[i]);
//                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
//                tempList.remove(tempList.size() - 1);
//            }
//        }
//    }

    // 自己的写的

    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, res, curr,0);
        return res;
    }
    // 可能会出现重复的情况 [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]，怎么办
    // 可先排序，for循环不要从 0 开始, 使用一个 start标识

    // Sum 可不用
    private void backtrack(int[] nums, int target, List<List<Integer>> res, List<Integer> curr, int start){
        if ( target == 0){
            // 要用 new 新建 对象，为什么？
            res.add(new ArrayList<>(curr));
            return;
        }
        else{
            for (int i = start; i < nums.length && target - nums[i] >= 0; i++) {
                curr.add(nums[i]);
                backtrack(nums, target - nums[i], res, curr, i );
                curr.remove(curr.size() - 1);
            }
        }
    }
}

