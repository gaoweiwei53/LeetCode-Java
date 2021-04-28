package p136_Single_Number;

class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

// 使用异或运算：ab值不同结果为 1， 相同结果为0
/* 1. 一个数与0异或运算结果为本身
*  2. 一个数与本身异或运算结果为0
*  3. a^b^a 结果为出现次数为1的那个数
*  4. 异或运算满足交换率
* */