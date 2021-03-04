package p50_Pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0f) return 0.0d;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            // 取余数 n % 2 等价于判断二进制最右位 n & 1 （与操作）： 判断 n 二进制最右一位是否为 1
            // 当 n & 1 = 1 时：将当前 x 乘入 res
            if((b & 1) == 1) res *= x;
            // 执行 x = x^2
            x *= x;
            //  向下整除 n // 2 等价于 右移一位 n >>1
            // 执行 n 右移一位
            b >>= 1;
        }
        return res;


    }
}
