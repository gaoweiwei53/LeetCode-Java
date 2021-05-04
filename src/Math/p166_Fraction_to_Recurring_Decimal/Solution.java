package p166_Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // If either one is negative (not both)
        // ^ 如果相对应位值相同，则结果为0，否则为1
        //TODO
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }

        // Convert to Long or else abs(-2147483648) overflows

        // 被除数
        long dividend = Math.abs(Long.valueOf(numerator));

        // 除数
        long divisor = Math.abs(Long.valueOf(denominator));

        // 将整数部分存入
        fraction.append(String.valueOf(dividend / divisor));

        long remainder = dividend % divisor;
        // 如果余数为0，则直接返回结果
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");

        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            // 记录余数出现在小数部分的位置，以便在出现循环的地方插入括号
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));

            remainder %= divisor;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        int a = 22;
        int b = 7;
        String s = new Solution().fractionToDecimal(a, b);
        System.out.println(s);
    }

}
