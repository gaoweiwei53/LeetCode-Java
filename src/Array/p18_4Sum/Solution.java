package p18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        for (int i = 0; i < nums.length - 3 ; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2 ; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r){
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        result.add(list);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                    else if (nums[i] + nums[j] + nums[l] + nums[r] < target)
                        l++;
                    else
                        r--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = Solution.fourSum(new int[]{0,0,0,0},0);
        System.out.println(result);
    }
}
