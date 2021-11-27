package p53_Maximum_Subarray;

class Solution {
    public int maxSubArray(int[] nums) {
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
    public int maxSubArray2(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(sum < 0){
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
            if(max < sum){
                max = sum;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int res = new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }
}

