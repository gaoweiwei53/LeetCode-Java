package p209_Minimum_Size_Subarray_Sum;

import java.util.Scanner;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum  = 0;
        int min = Integer.MAX_VALUE;
        while(right < nums.length){
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums= new int[]{1,1,1,1,1,1,1,1};
        int target = 11;

//        Scanner scanner = new Scanner(System.in);
//        String[] s = scanner.nextLine().split(" ");
//        String[] numsStr = s[0].split(",");
//        int[] nums = new int[numsStr.length];
//        for (int i = 0; i < numsStr.length; i++) {
//            nums[i] = Integer.parseInt(numsStr[i]);
//        }
//        int target = Integer.parseInt(s[1]);
        int res = new Solution().minSubArrayLen(target, nums);
        System.out.println(res);


    }
}
