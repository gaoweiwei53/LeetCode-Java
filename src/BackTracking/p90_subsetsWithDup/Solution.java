package BackTracking.p90_subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        //走过的所有路径都是子集的一部分，所以都要加入到集合中
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            // 其他的代码和 78题没区别
            if (i > start && nums[i] == nums[i-1]) continue;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
