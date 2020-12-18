package DynamicPrograming.p62_Unique_Paths;
/*
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int output = new Solution().uniquePaths(0,0);
        System.out.println(output);
    }
}

 */
class Solution {
    //动态规划
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;

        int[][] dp = new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0;j<n; j++){
                if(i==0 || j==0){
                    dp[i][j]=1; //到达该位置只有一条路径
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; //动态规划
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int output = new Solution().uniquePaths(3,7);
        System.out.println(output);
    }
}