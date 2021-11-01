package 剑指offer.easy;

/**
 * TODO
 * 实现 strStr() LeetCode 28
 * 在主字符串中找出子字符串出现的第一个位置 (从0开始)，不包含子字符串时，返回-1
 * @author 苞谷洁子
 * @ClassName StrStr
 * @date 2020/10/28 21:40
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(haystack.length() == needle.length()){
            return haystack.compareTo(needle) == 0 ? 0 : -1;
        }

        for(int i = 0 ; i <= haystack.length()-needle.length() ; i++){
            String str = haystack.substring(i,i+needle.length());
            if(str.compareTo(needle) == 0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "hello";
        String needle = "hello";
        int i = strStr.strStr(haystack, needle);
        System.out.println(i);
    }
}
