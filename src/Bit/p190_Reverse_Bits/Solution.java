package p190_Reverse_Bits;

public class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
/*
    算术右移 >> ：舍弃最低位，高位用符号位填补；
    逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
*/

// 在 Java 中需要使用逻辑右移，即 >>> ，while 的判断条件才能是 n != 0