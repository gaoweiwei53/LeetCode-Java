package p772_Basic_Calculator_III;

import java.util.*;

public class Solution {
    public int calculate(String s) {

        List<String> reversePolishExpression = reversePolishExpression(s);

        return computeReversePolishExpression(reversePolishExpression);

    }

    // 将中缀表达式转换为逆逆波兰表达式
    // 通用计算器：操作符包含了'+', '-', '*', '/'
    public List<String> reversePolishExpression(String s) {

        char[] chs = s.toCharArray();
        int n = chs.length;
        // 符号栈
        Deque<String> stack = new LinkedList<>();
        // 存储转换结果
        ArrayList<String> result = new ArrayList<>();
        // 缓存变量  - 用来对多位数进行处理
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < n; i++) {
            //System.out.print((char)chs[i] + " ");
            // 遇到空格, 直接跳过
            if (chs[i] == ' ')
                continue;

            // 遇到了数字, 直接输出, 但是要主要多位数的处理
            if (chs[i] >= '0' && chs[i] <= '9') {
                // 清空缓存数据
                temp.delete(0, temp.length());
                // 多位数处理
                while (i < n && chs[i] >= '0' && chs[i] <= '9') {
                    temp.append(chs[i]);
                    i++;
                }
                i--;
                //System.out.println(temp.toString());
                result.add(temp.toString());
            }
            // 遇到左括号, 直接进栈
            else if (chs[i] == '(') {
                stack.push("(");
            }
            // 遇到')'不断出栈, 直到遇到'('括号或栈为空
            else if (chs[i] == ')') {
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    result.add(stack.pop());
                }
                // 弹出'('
                if (!stack.isEmpty())
                    stack.pop();
            }
            // 遇到 '+', '-', '*', '/'操作符, 需要根据运算优先级进行相应处理
            else {
                // 1. 若栈为空, 栈顶元素为'(', 并且当前操作符大于栈顶运算符, 则直接进栈
                // 3. 当前操作符小于或等于栈顶运算符, 则不断进行出栈, 直到满足条件1
                while (!stack.isEmpty() && !"(".equals(stack.peek()) && getPriority(String.valueOf(chs[i])) <= getPriority(String.valueOf(stack.peek()))) {
                    result.add(stack.pop());
                }
                stack.push(String.valueOf(chs[i]));
            }

        }

        while(!stack.isEmpty())
            result.add(stack.pop());

        return result;
    }

    // 计算逆波兰表达式
    public int computeReversePolishExpression (List<String> RPE) {
        Deque<String> stack = new LinkedList<>();
        for (String s : RPE) {
            // 遇到了数字
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int m = Integer.parseInt(stack.pop());
                if (stack.isEmpty()) {
                    stack.push("-" + String.valueOf(m));
                } else {
                    int n = Integer.parseInt(stack.pop());
                    int res = 0;
                    if ("+".equals(s)) {
                        res = m + n;
                    } else if ("-".equals(s)) {
                        res = n - m;
                    } else if ("*".equals(s)) {
                        res = m * n;
                    } else {
                        res = n / m;
                    }
                    stack.push(String.valueOf(res));
                }

            }
        }
        return Integer.parseInt(stack.pop());
    }


    // 返回运算符优先级
    public int getPriority(String s) {
        if ("+".equals(s) || "-".equals(s))
            return 1;
        if ("*".equals(s) || "/".equals(s))
            return 2;
        return -1;
    }

    // 方法2
    public int calculate2(String s) {
        return dfs(s, 0)[0];

    }

    private int[] dfs(String s, int index) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int[] root = dfs(s, ++i);
                num = root[0];
                i = root[1];
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch (sign) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(num * st.pop());
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                return new int[]{sum(st), i};
            }
        }
        return new int[]{sum(st), s.length() - 1};
    }

    private int sum(Stack<Integer> st) {
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }

}
