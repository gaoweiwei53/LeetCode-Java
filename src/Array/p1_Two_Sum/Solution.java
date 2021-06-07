package p1_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int remain = target - nums[i];
            for(int j = i + 1; j < n; j++){
                if(remain == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    // 暴力解法有点慢
    // 使用hash表
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (numMap.containsKey(target - nums[i])){
                return new int[]{numMap.get(target - nums[i]),i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{0};
    }
}
