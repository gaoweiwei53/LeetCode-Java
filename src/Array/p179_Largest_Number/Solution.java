package p179_Largest_Number;



import java.util.Arrays;

class Solution {
    // 数字转为字符串不要用 + "", 效率太低
    public String largestNumber(int[] nums) {

        int n = nums.length;
        String numsToWord[] = new String[n];
        for(int i=0;i<n;i++){

            numsToWord[i] = String.valueOf(nums[i]);
        }
        //compareTo()方法比较的时候是按照ASCII码逐位比较的
        //通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        //所以[3,30,34]排序后变为[34,3,30]
        //[233，23333]排序后变为[23333，233]
        Arrays.sort(numsToWord,(a,b)-> (b+a).compareTo(a+b));
        //如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if(numsToWord[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< n; i++){
            sb.append(numsToWord[i]);
        }
        return sb.toString();
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
        // 排序的元素必须是包装类
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