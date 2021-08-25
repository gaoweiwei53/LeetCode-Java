package nc91;

public class Solution {
    public int[] LIS1 (int[] arr) {
        int[] dp = new int[arr.length];
        int[] tail = new int[arr.length];
        dp[0] = 1;
        int endIndex = 0;
        tail[endIndex] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > tail[endIndex]) {
                ++endIndex;
                tail[endIndex] = arr[i];
                dp[i] = endIndex + 1;
            } else {
                int left = 0, right = endIndex;
                while (left <= right) {
                    // 注意这里 left <= right 而不是 left < right，我们要替换的是第一个比 arr[i] 大的元素
                    int mid = (right + left) / 2;
                    if (tail[mid] > arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                tail[left] = arr[i];
                dp[i] = left + 1;
            }
        }

        int[] res = new int[endIndex + 1];
        for (int i = dp.length - 1; i >= 0; --i) {
            if (dp[i] == endIndex + 1) {
                res[endIndex] = arr[i];
                --endIndex;
            }
        }
        return res;
    }

    public int[] LIS2 (int[] arr) {
        // write code here
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int[] tail = new int[arr.length]; // 记录长度为l的子序列最大值（末尾值）
        // 用于优化dp，便于获得当前节点结尾的子序列长度
        int[] dp = new int[arr.length]; // 记录以当前位置元素结尾的子序列长度（用来追溯子序列节点）
        int maxlen = 1;

        tail[1] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            //当当前元素大于最长子序列的末尾元素时，
            if (arr[i] > tail[maxlen]) {
                //最长子序列长度+1
                tail[++maxlen] = arr[i];
                //当前元素结尾的序列长度为maxlen
                dp[i] = maxlen;
            } else if (arr[i] < tail[maxlen]) {
                //从小到大找寻子序列中末尾元素大于当前元素的子序列长度，更新两个状态数组
                int left = findFirstBigNum(tail, arr[i], maxlen);
                tail[left] = arr[i];
                dp[i] = left;
            }
        }
        int[] res = new int[maxlen];
        for (int i = dp.length - 1; i >=0; i--) {
            if (dp[i] == maxlen) {
                res[--maxlen] = arr[i];
            }
        }
        return res;
    }
    public int findFirstBigNum(int[] arr, int pivot, int maxlen) {
        int left = 1;
        int right = maxlen;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (pivot < arr[mid]) {
                right = mid - 1;
            }
            if (pivot >= arr[mid]) {
                left = mid + 1;
            }
        }
        return left;
    }
    public int[] LIS3 (int[] arr) {
        // write code here
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int[] tail = new int[len];
        tail[0] = arr[0];
        int tailEnd = 0;
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (arr[i] > tail[tailEnd]) {
                tailEnd++;
                tail[tailEnd] = arr[i];
                dp[i] = tailEnd + 1;
            } else {
                int left = 0;
                int right = tailEnd;
                while (left < right) {

                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = arr[i];
                dp[i] = left + 1;
            }

        }
        // end = 4;
        tailEnd++;
        int[] res = new int[tailEnd];
        for(int i = dp.length - 1; i >= 0; i--){
            if(dp[i] == tailEnd){

                res[--tailEnd] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,3,6,4,8,9,7};
        int[] res = new Solution().LIS3(input);
        for (int i: res){
            System.out.println(i);
        }
    }
}
