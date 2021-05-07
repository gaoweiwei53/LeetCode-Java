package p179_Largest_Number;


import java.sql.SQLOutput;
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];

        // 时间复杂度O(n^2)
        // 降序排列
        // 比较器返回正数则发生交换
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            // 降序排列
            return sb.compareTo(sa);
        });


        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        // 除去前导为0的字符
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
    public static void main(String args[]) {
        String str1 = "Strings";
        String str2 = "Stringsa";
        String str3 = "Stringsdaaaa ";

//        int result = str1.compareTo( str2 );
//        System.out.println(result);
//
//        result = str2.compareTo( str3 );
//        System.out.println(result);
//
//        result = str3.compareTo( str2 );
//        System.out.println(result);

        String[] s1 =new String[]{"32","17","41","3"};
        String[] s2 =new String[]{"1","5","9"};
        Arrays.sort(s1,(a,b)->{
            String sa = a + b, sb = b + a ;
            return sa.compareTo(sb);
        });
        for (String s: s1){
            System.out.println(s);
        }


        Integer[] arr = new Integer[]{3,1,4,1,5,9};
        Arrays.sort(arr, (a, b)-> b - a);
        for (int a: arr){
            System.out.print(a);
        }
    }
}
/* String.compareTo()方法: s1.compareTo(s2)
   从左往右依次比较两个字符串对应位置的字符的ASCII大小，直到遇到不相等的时候或其中一个字符串结束
   若其中一个字符串结束，则返回两个字符串字符个数的差
   若遇到不想等，返回ASCII的差值
* */