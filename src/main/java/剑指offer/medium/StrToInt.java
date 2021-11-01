package 剑指offer.medium;

import java.util.Scanner;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName MyAtoi
 * @date 2021/10/26 20:44
 */
public class StrToInt {
    public static int strToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        long res = 0;
        int index = 0;
        boolean flag = false;
        int m = 0;
        while (index<str.length() && !(str.charAt(index) <= 'z' && str.charAt(index) >= 'a') && str.charAt(index) != '.'){
            char c = str.charAt(index);
            if(res!=0 || flag){
                if(c <= '9' && c >= '0'){
                    res = res*10 + (int)Math.pow(-1,m)*(c - '0');
                    if (res < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                    if (res > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }else{
                    break;
                }
            }else{
                switch (c){
                    case '-':m = 1;
                    case '+':
                        flag = true;
                        break;
                    case ' ':
                        if(flag){
                            return 0;
                        }
                        break;
                    default:
                        res = (int)Math.pow(-1,m)*(c-'0');
                        flag = true;
                }
            }
            index ++;
        }
        return (int) res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        System.out.println(strToInt(next));
    }
}
