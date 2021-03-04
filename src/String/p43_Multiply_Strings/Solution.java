package p43_Multiply_Strings;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();

/*        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int [] res = new int [m+n];
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                int num = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = num+res[p2];
                res[p2] = sum % 10;
                //此处的+=是为了处理进位用的，例如19*19，列出竖式看一下就知道了。
                res[p1] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();

        for(int i = 0 ;i<res.length;i++){
            // 结果前缀可能存的 0（未使用的位）
            //这里的i==0是因为只可能出现首位为0的情况，例如一个三位数乘一个两位数不可能出现结果是一个三位数的情况。所以只需要判断首位即可。
            if(res[i] == 0 && i == 0){
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();*/
    }

    public static void main(String[] args) {
        String res = new Solution().multiply("123","45");
        System.out.println(res);
    }
}
