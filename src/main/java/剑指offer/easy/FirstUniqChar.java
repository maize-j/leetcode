package 剑指offer.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * leetcode 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 输入：s = ""
 * 输出：' '
 * @author 苞谷洁子
 * @ClassName FirstUniqChar
 * @date 2021/10/16 19:42
 */
public class FirstUniqChar {
    public static char firstUniqChar(String s) {
        if(s == null || "".equals(s)){
            return ' ';
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        int index = 0;
        while (index < s.length() && map.get(s.charAt(index)) != 1){
            index ++ ;
        }
        if(index >= s.length()){
            return ' ';
        }
        return s.charAt(index);
    }

    public static void main(String[] args) {
//        String str = "abaccdeff";
        String str = "cc";
        char c = firstUniqChar(str);
        System.out.println(c);
    }
}
