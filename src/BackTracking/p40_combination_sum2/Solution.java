package p40_combination_sum2;

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
public class Solution {
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
