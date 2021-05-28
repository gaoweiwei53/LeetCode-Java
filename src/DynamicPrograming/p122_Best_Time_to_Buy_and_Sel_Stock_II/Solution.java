package p122_Best_Time_to_Buy_and_Sel_Stock_II;

public class Solution {
    public int maxProfit(int[] prices) {
        int lowPrice = prices[0];
        int profit = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= lowPrice){
                lowPrice = prices[i];
            }
            else {
                profit = prices[i] - lowPrice;
                sum += profit;
                lowPrice = prices[i];
            }
        }
        return sum;
    }
    // 动态规划，和121对比
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
/*
* [7, 1, 5, 6] 第二天买入，第四天卖出，收益最大（6-1），所以一般人可能会想，怎么判断不是第三天就卖出了呢? 这里就把问题复杂化了，
* 根据题目的意思，当天卖出以后，当天还可以买入，所以其实可以第三天卖出，第三天买入，第四天又卖出（（5-1）+ （6-5） === 6 - 1）。
* 所以算法可以直接简化为只要今天比昨天大，就卖出。
* */
