package p11_ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
/*        int container = 0;
        int width = height.length;
        for (int i = 0; i < width; i++) {
            for (int j = i + 1; j < width; j++) {
                int h = height[i] > height[j]?height[j]:height[i];
                if (container < ((j - i) * h)){
                    container = (j - i) * h;
                }
            }
        }
        return container;*/
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result);
    }
}
