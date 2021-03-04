package p53_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {

        /*
        * 动态规划
        * 如果sum > 0，则说明sum对结果有增益效果，则sum保留并加上当前遍历数字
        * 如果sum < 0，则说明sum对结果无增益效果，需要舍弃，则sum 直接更新为当前遍历数字
        * 时间复杂度：O(n)
        * */
//        int ans = nums[0];
//        int sum = 0;
//        for(int num: nums) {
//            if(sum > 0) {
//                sum += num;
//            } else {
//                sum = num;
//            }
//            ans = Math.max(ans, sum);
//        }
//        return ans;

        // 动态规划
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int res = new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}

