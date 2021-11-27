package p72_Edit_Distance;

public class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        // dp[i][j] 代表word1前i个字符转换成word2前j字符需要最少步数
        // 增，dp[i][j] = dp[i][j - 1] + 1
        // 删，dp[i][j] = dp[i - 1][j] + 1
        // 改，dp[i][j] = dp[i - 1][j - 1] + 1

        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 当前比较字符相等时
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //  配合增删改这三种操作，取三种的最小
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
