package knapsack;

/**
 * 01背包问题：给定一个可装载容量为 W 的背包和 N 个物品，其中第 i 个物品的重量为 wt[i]， 价值为 val[i]，
 *      问最多能装的价值是多少？
 */

// 状态有两个：包的容量和可选的物品数

public class Solution {


    // val{1,2,4,2,3}
    // wt{2,3,3,1,2}
    // dp[i][w]的含义为：对于前i个物品，当背包的容量为w时，可以装的最大价值是dp[i][w]
    int knapsack(int W, int N, int[] wt, int[] val){
        int[][] dp = new int[N+1][W+1];

        // dp[0][..] = 0;
        // dp[..][0] = 0;
        for (int i = 1; i <= N ; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0){
                    //不装入背包
                    dp[i][w] = dp[i-1][w];
                }
                else {
                    // 如果能装下当前物品i，则可要比较 装和不装的情况下的价值，取较大者
                    // 本应是dp[i-1][w-wt[i]] + val[i]
                    // 把val和wt数组的索引减1就修复了索引偏移的问题

                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i-1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }
}
