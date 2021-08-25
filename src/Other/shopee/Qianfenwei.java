package shopee;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Qianfenwei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            String res = new Qianfenwei().qianfenwei2(sc.nextInt());
            System.out.println(res);
        }
    }
    private String qianfenwei(int num){
          // 原地修改不可取

        String s = num + "";
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {

            stringBuilder.append(s.charAt(i));
            if(i > 0 && i < len - 1 && (i + 1) % 3 == 0 )
                stringBuilder.append(',');

        }
        return stringBuilder.toString();
    }

    // 最可取的方法
    private String qianfenwei2(int num){
        String s = num + "";
        String res = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            res += s.charAt(i);
            if(i > 0 && i < len - 1 && (i + 1) % 3 == 0 )
                res += ",";
        }
        return res;
    }
}
