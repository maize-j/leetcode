package 剑指offer.easy;

/**
 * TODO
 * leetcode 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * @author 苞谷洁子
 * @ClassName ReverseLeftWords
 * @date 2021/10/19 21:12
 */
public class ReverseLeftWords {
    public static String reverseLeftWords(String s, int n) {

        //取余计算
        //for(int i = n; i < n + s.length(); i++)
        //            res += s.charAt(i % s.length());

        return null;
    }

    public static void main(String[] args) {

        String str = "";
        String s = reverseLeftWords(str,5);
        System.out.println(s);
    }
}
