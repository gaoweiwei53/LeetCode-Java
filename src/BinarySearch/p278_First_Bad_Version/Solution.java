package p278_First_Bad_Version;

public class Solution {
    // 更优的版本
    public static  int firstBadVersion(int n, int target) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

/*        int l = 1, r = n, mid = 0;
        while (l <= r){
            mid = l + (r - l) / 2;

            if(isBadVersion(mid)){
                r = mid;
            }
            else if(!isBadVersion(mid)){
                l = mid + 1;
            }
            if(l == r && mid == r){
                break;
            }
        }
        return mid;*/
    }
    public static boolean isBadVersion(int n){
        return n == 5;
    }
}
