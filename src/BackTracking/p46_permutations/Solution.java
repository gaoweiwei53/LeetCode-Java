package p46_permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums  = {1,2,3};
        new Solution().permute(nums);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList;
    }
    private void backtrack(List<List<Integer>> resultList, List<Integer> currentList, int [] nums){
        if(currentList.size() == nums.length){
            resultList.add(new ArrayList<>(currentList));
        }
        else{

            for(int i = 0; i < nums.length; i++){
                if(currentList.contains(nums[i])) continue; // element already exists, skip
                currentList.add(nums[i]);
                backtrack(resultList, currentList, nums);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
