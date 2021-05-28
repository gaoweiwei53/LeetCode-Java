package p322_Coin_Change;

import java.util.Arrays;

public class Solution {
    /**
     *
     * @param coins 可用的硬币
     * @param amount  金额
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        // dp[i] 表示的凑成总金额为n所需的最少的硬币个数
        // 状态转移方程：dp[i - coins[j]] + 1
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
