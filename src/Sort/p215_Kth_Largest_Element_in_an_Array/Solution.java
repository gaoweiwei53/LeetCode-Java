package p215_Kth_Largest_Element_in_an_Array;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int maxIndex;
        for(int i = 0; i < k; i++){
            maxIndex = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[maxIndex]){
                    maxIndex = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = tmp;
        }
        return nums[k - 1];
    }
}
