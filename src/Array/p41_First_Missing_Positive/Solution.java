package p41_First_Missing_Positive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        //因为是返回第一个正整数，不包括 0，所以需要长度加1，细节1
        int[] res = new int[nums.length + 1];
        //将数组元素添加到辅助数组中
        for (int x : nums) {
            if (x > 0 && x < res.length) {
                res[x] = x;
            }
        }
        //遍历查找,发现不一样时直接返回
        for (int i = 1; i < res.length; i++) {
            if (res[i] != i) {
                return i;
            }
        }
        //缺少最后一个，例如 1，2，3此时缺少 4 ，细节2
        return res.length;
    }
}
