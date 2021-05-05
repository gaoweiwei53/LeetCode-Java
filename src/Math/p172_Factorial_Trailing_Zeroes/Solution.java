package p172_Factorial_Trailing_Zeroes;

public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
    // 更容易理解：结果为 n/5 + n/25 + n/125 + * * *
    public int trailingZeroes2(int n) {
        int init = 5;
        int res = 0;
        while (init <= n) {
            res += n / init;
            init *= 5;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(20));
    }
}
