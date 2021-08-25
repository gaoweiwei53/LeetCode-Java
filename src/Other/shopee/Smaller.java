package shopee;

import java.util.Arrays;
import java.util.Scanner;

public class Smaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
//           int res = new Smaller().smallerThanN(sc.nextInt());
            String res = new Smaller().smallerThanN(sc.nextInt());
            System.out.println(res);

        }
    }
    private String smallerThanN(int num){
        char[] charArray = Integer.toString(num).toCharArray();
        int len = charArray.length;
        for (int i = len -1 ; i > 0 ; i--) {
            if(charArray[i] < charArray[i - 1]){
                char tmp = charArray[i];
                charArray[i] = charArray[i - 1];
                charArray[i - 1] = tmp;
                break;
            }
        }
        String res = "";
        for (char c: charArray){
            res += c;
        }
        return res;
    }
}
