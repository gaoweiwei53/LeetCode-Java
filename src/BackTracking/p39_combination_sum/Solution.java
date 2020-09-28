package p39_combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5,3,2};
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
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null) return list;
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, list, curr, 0, 0);
        return list;
    }
    // 可能会出现重复的情况 [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]，怎么办
    // 可先排序，for循环不要从 0 开始, 使用一个 start标识
    private void backtrack(int[] nums, int target, List<List<Integer>> list, List<Integer> curr, int sum, int start){
        if (sum == target){
            // 要用 new 新建 对象，为什么？
            list.add(new ArrayList<>(curr));
            return;
        }
        else{
            for (int i = start; i < nums.length && sum + nums[i] <= target; i++) {
                curr.add(nums[i]);
                backtrack(nums, target, list, curr, sum + nums[i],i);
                curr.remove(curr.size() - 1);
            }
        }
    }
}

