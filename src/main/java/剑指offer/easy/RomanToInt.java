package 剑指offer.easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO
 * 罗马数字转整数 LeetCode 13
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * @author 苞谷洁子
 * @ClassName RomanToInt
 * @date 2020/10/27 17:37
 */
public class RomanToInt {
    public int romanToInt(String str) {
        char[] chars = str.toCharArray();
        String regex = "[IVXLCDM]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;
        if(chars.length == 1){
            switch (chars[0]){
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return  10;
                case 'L':
                    return  50;
                case 'C':
                    return  100;
                case 'D':
                    return  500;
                case 'M':
                    return  1000;
            }
        }
        int num = 0;
        for(int i = 0;i<chars.length-1;i++){
            matcher = pattern.matcher(String.valueOf(chars[i]));
            if(!matcher.matches()){
//                throw new RuntimeException("字符串中有非罗马数数字！");
                continue;
            }
            switch (chars[i]){
                case 'I':
                    if(chars[i+1] == 'V' || chars[i+1] == 'X'){
                        num = num - 1;
                    }else if(chars[i+1] == 'I'){
                        num = num + 1;
                    }else{
//                        throw new RuntimeException("该罗马数字不合规范！");
                        return 0;
                    }
                    break;
                case 'V':
                    num = num + 5;
                    break;
                case 'X':
                    if(chars[i+1] == 'L' || chars[i+1] == 'C'){
                        num = num - 10;
                    }else if(chars[i+1] == 'I' || chars[i+1] == 'V' || chars[i+1] == 'X'){
                        num = num + 10;
                    }else{
//                        throw new RuntimeException("该罗马数字不合规范！");
                        return 0;
                    }
                    break;
                case 'L':
                    num = num + 50;
                    break;
                case 'C':
                    if(chars[i+1] == 'D' || chars[i+1] == 'M'){
                        num = num - 100;
                    }else{
                        num = num + 100;
                    }
                    break;
                case 'D':
                    num = num + 500;
                    break;
                case 'M':
                    num = num + 1000;
                    break;
            }
        }
        switch (chars[chars.length-1]){
            case 'I':
                return num + 1;
            case 'V':
                return num + 5;
            case 'X':
                return  num + 10;
            case 'L':
                return  num + 50;
            case 'C':
                return  num + 100;
            case 'D':
                return  num + 500;
            case 'M':
                return  num + 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
//        String str = "III"; //3
//        String str = "IV"; //4
//        String str = "IX"; //9
//        String str = "LVIII"; //58
//        String str = "MCMXCIV"; //1994
//        String str = "IC"; //不合题意
//        String str = "IM"; //不合题意
        String str = "DCXXI"; //621
        int i = romanToInt.romanToInt(str);
        System.out.println(i);
    }
}
