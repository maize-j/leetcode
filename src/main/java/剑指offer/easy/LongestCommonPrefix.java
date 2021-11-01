package 剑指offer.easy;

/**
 * TODO
 * 最长公共前缀问题 LeetCode14
 * @author 苞谷洁子
 * @ClassName LongestCommonPrefix
 * @date 2020/10/28 14:56
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        String str = strs[0];
        for(int i = 1;i<strs.length;i++){
            char[] chars1 = strs[i].toCharArray();
            char[] chars2 = str.toCharArray();
            int j = 0;
            for(;j<Math.min(chars1.length, chars2.length);j++){
                if(chars1[j] != chars2[j]){
                    break;
                }
            }
            //说明一个字符都没有匹配
            if(j == 0){
                return "";
            }
            str = str.substring(0,j);
        }
        return str;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//        String[] str = {"flower","flow","flight"};
        String[] str = {"dog","racecar","car"};
        String s = longestCommonPrefix.longestCommonPrefix(str);
        System.out.println("最长公共子串："+s);
    }
}
