package p15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//如何避免重复的结果
// 排序！
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 下面的代码为什么不对？
/*        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3 || nums == null) return ans;
        Arrays.sort(nums);
        int i = 0;
        
        while (i < nums.length && nums[i] <= 0 ) {
            // 问题出现在这里，if条件满足后下面的代码会执行而不是继续下一轮判断！！！！
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
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
                else if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }
                else {
                    r--;
                }
            }
            i++;
        }
        return ans;*/
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3 || nums == null) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = nums.length - 1;
            while (l < r){
                if (nums[i] + nums[l] + nums[r] == 0) {
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
                else if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return ans;

/*        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int r = n - 1;
            int target = -nums[i];
            // 枚举 b
            for (int l = i + 1; l < n; ++l) {
                // 需要和上一次枚举的数不相同
                if (l > i + 1 && nums[l] == nums[l - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (l < r && nums[l] + nums[r] > target) {
                    --r;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (l == r) {
                    break;
                }
                if (nums[l] + nums[r] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                }
            }
        }
        return ans;*/
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        ans = new Solution().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        System.out.println(ans);
    }
}
