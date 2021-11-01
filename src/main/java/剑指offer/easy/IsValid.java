package 剑指offer.easy;

import java.util.Stack;

/**
 * TODO
 * 有效的括号问题 LeetCode20
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @author 苞谷洁子
 * @ClassName IsValid
 * @date 2020/10/28 15:54
 */
public class IsValid {
    public boolean isValid(String s) {
        if(s.length() == 0 || s == null){
            return true;
        }else if(s.length()%2 != 0){ //输入的字符串长度为奇数
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            switch (chars[i]){
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                default:
                    stack.push(chars[i]);
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
//        String s = "{[]}";
//        String s = "((";
        String s = "){";
        boolean valid = isValid.isValid(s);
        System.out.println(valid);
    }
}
