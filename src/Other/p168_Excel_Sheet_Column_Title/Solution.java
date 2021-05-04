package p168_Excel_Sheet_Column_Title;

public class Solution {
    public static String convertToTitle(int columnNumber) {

        // 难理解
        StringBuilder buffer = new StringBuilder();
        while (columnNumber != 0) {

            // 核心代码
            int remainder = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            char res = (char) (64 + remainder);
            buffer.insert(0, res);
            columnNumber = (columnNumber - remainder) / 26;
        }
        return buffer.toString();
    }
    public  static  String  convertToTitle2(int columnNumber){
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber != 0){
            columnNumber--;

            int remainder = columnNumber % 26;
            char res = (char) (65 + remainder );
            stringBuilder.insert(0, res);
            columnNumber /= 26;
        }
        return  stringBuilder.toString();
    }

    public  String convert10to26(int num){

        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0){
            int remainder = num % 26;
            stringBuilder.insert(0,remainder);
            num = num / 26;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert10to26(27));
    }
}
/*
本质就是进制转换，10进制转26进制，但有所不同的是正常转换成26进制的余数是0-25，
而本题的余数是1-26（对应A-Z），为了消除差距的这个1，有两种方法：
1) 每次将被除数减一
2) 对值为 26 的倍数单独处理，保留为 26，而不取余
*/
