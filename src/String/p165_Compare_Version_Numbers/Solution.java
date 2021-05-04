package p165_Compare_Version_Numbers;

class Solution {
    public int compareVersion(String version1, String version2) {

        /*
        split() 方法根据匹配给定的正则表达式来拆分字符串。

        注意： . 、 $、 | 和 * 等转义字符，必须得加 \\

        注意：多个分隔符，可以用 | 作为连字符
        */

        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions

        //  Integer.parseInt可以将开头的0去掉
        // 位数短的填0
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "0.1";
        String version2= "1.1";
        int res = new Solution().compareVersion(version1, version2);
        System.out.println(res);
    }
}
