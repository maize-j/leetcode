package test;

import java.util.Scanner;
import java.util.Stack;

/**
 * TODO
 * 共济科技
 * 2. 请实现括号匹配函数，函数输入是一个字符串s，是由括号（包括小括号、中括号、大括号,即”(”,”)”,”[”,”]”,”{”,”}”）、字母、数字组成，不需要对字符串s进行合法验证。
 * 返回 true 如果括号是匹配的，返回false如果括号不匹配。
 * @author 苞谷洁子
 * @ClassName GJTEst2
 * @date 2021/10/22 14:23
 */
public class GJTEst2 {

    public static boolean isLegel(String str){
        if(str == null || str.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index < str.length()){
            switch (str.charAt(index++)){
                case '{': stack.push('{');
                    break;
                case '[': stack.push('[');
                    break;
                case '(': stack.push('(');
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                default:
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isLegel(str));

    }

}
