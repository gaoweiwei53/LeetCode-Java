package p15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//如何避免重复的结果
// 排序！
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3 || nums == null) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = nums.length - 1;
            while (l < r){
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }
                else if ( tmp < 0){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        ans = new Solution().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        System.out.println(ans);
    }
}
