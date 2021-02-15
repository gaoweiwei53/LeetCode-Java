package p16_3Sum_Closest;


import java.util.Arrays;


public class Solution {
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int delta = Math.abs(sum -target);

        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int tmp = nums[i] + nums[l] + nums[r];
                if (Math.abs(tmp - target) < delta){
                    delta = Math.abs(tmp -target);
                    sum = tmp;
                }
                if (tmp - target < 0){
                        l++;
                    }

                else if (tmp - target > 0){
                        r--;
                    }
                else return sum;

                }
        }
        return sum ;
/*        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;*/

    }

    public static void main(String[] args) {
        int ans = Solution.threeSumClosest(new int[]{0,2,1,-3},1);
        System.out.println(ans);
    }

}
