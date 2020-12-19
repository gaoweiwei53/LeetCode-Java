package BackTracking.p40_combination_sum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 */
/*
public class p5_longestpalindromicsubstring.Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(out, new ArrayList<Integer>(), candidates, target, 0);
        return  out;
    }
    private void backtracking(List<List<Integer>> out, List<Integer> templist, int[] nums, int remain, int start){
        if(remain == 0)  out.add(new ArrayList<>(templist));
        else{
            for (int i = start; i < nums.length;i++){
                if (i > start && nums[i] == nums[i -1]) continue;
                templist.add(nums[i]);
                backtracking(out, templist, nums, remain - nums[i], i + 1);
                templist.remove(templist.size() - 1);
            }

        }

    }
}
*/
public class Solution{
    public static void main(String[] args) {
        int[] candiates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = new Solution().combiantionSum2(candiates, 8);
        System.out.println(res);
    }
    public List<List<Integer>> combiantionSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, new ArrayList<Integer>(), 0 );
        return res;
    }
    private static void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int start){
        if (target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        else{
            for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                curr.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, curr, i + 1);
                // i + 1 很重要， 若结果可由重复元素组成则为 i,如 39题。若结果 不能由重复元素，则为 i + 1
                curr.remove(curr.size() - 1);
            }
        }
    }
}