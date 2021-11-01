package 剑指offer.easy;

/**
 * TODO
 * 外观数组
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312212
 * ...
 * @author 苞谷洁子
 * @ClassName CountAndSay
 * @date 2020/10/29 20:37
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 0){
            return "";
        }
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        String str = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
        //计数同一个字符出现了几次
        int j = 0;
        for (int i = 1; i < str.length() + 1; i++) {
            if (i == str.length()){
                sb.append(i - j).append(str.charAt(j));
            }else if(str.charAt(i) != str.charAt(j)){
                sb.append(i-j).append(str.charAt(j));
                j = i;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        int n = 4;
        String str = countAndSay.countAndSay(n);
        System.out.println("str:"+str);
    }
}
