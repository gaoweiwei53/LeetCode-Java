package p167_Two_Sum_II_Input_array_is_sorted;

public class Solution {

    // 二分查找
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length ; i++){
            int remain = target - numbers[i];
            int left = i + 1, right = numbers.length - 1;

            while(left <= right){
                int mid =  left + (right - left) / 2;
                if(numbers[mid] == remain) {
                    return new int[]{i+1, mid + 1};
                }

                if(numbers[mid] > remain){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 双指针
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                return new int[]{left + 1, right + 1};
            }
            else if (numbers[left] + numbers[right] < target){
                left++;
            }
            else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
