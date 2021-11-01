package 剑指offer.easy;

/**
 * TODO
 * leetcode 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * @author 苞谷洁子
 * @ClassName ReverseWords
 * @date 2021/10/19 20:59
 */
public class ReverseWords {
    public static String reverseWords(String s) {

        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer("");
        for(int i = strs.length-1;i>=0;i--){
            if(!strs[i].equals("")){
                sb.append(strs[i] + " ");
            }
        }
        String res = new String(sb);
        return res.trim();
    }

    public static void main(String[] args) {
//        String str = "I am a student. ";
        String str = "a good   example";
        String s = reverseWords(str);
        System.out.println(s);
    }

}
