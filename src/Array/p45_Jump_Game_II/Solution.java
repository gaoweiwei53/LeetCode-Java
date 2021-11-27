package p45_Jump_Game_II;

public class Solution {
    // 使用贪心思想，每次寻找局部最优解，全局最优解由局部最优解组合
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        // 注意i < length - 1， 表示最后一个元素不便利，因为不需要跳了
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 维护每次跳跃的边界，到达边界时，更新steps
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
