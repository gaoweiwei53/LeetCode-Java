package p55_Jump_Game;

public class Solution {
    public boolean canJump(int[] nums) {

        // 能跳的最远距离
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean canJump = new Solution().canJump(new int[]{3,2,1,0,4});
        System.out.println(canJump);
    }
}
