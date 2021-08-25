package p509_Fibonacci_Number;

import java.util.Scanner;

class Solution {
    public int fib1(int n) {
        if(n <= 1) return n;
        return fib2(n - 1) + fib2(n - 2);

    }
    public int fib2(int n) {
        if(n < 2) return n;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int fib3(int n) {
        if(n < 2) return n;
        int first  = 0, second = 1;
        int res = 0;
        for(int i = 2; i <= n; i++){
            res = first + second;
            first = second;
            second = res;

        }
        return res;

    }
}


class RunoobTest {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner scan = new Scanner(System.in);

        double sum = 0;
        int m = 0;

        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }

        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
    }
}