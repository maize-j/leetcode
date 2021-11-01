package 剑指offer.easy;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName LengthOfLastWord
 * @date 2020/11/1 16:42
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] str = s.split(" ");
        if(str.length == 0){
            return 0;
        }else {
            String lastWord = str[str.length-1];
            return lastWord.length();
        }
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String str = "Hello World";
        int i = lengthOfLastWord.lengthOfLastWord(str);
        System.out.println(i);
    }
}
