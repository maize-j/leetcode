package 剑指offer.medium;

/**
 * TODO
 * leetcode 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 输入: "bbbbb"
 * 输出: 1
 * 输入: "pwwkew"
 * 输出: 3
 * @author 苞谷洁子
 * @ClassName LengthOfLongestSubstring
 * @date 2021/10/13 22:03
 */
public class LengthOfLongestSubstring {
    
    public static int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        if(s.length() <= 1){
            return s.length();
        }
        int index1 = 0, index2 = 1;
        int maxLength = 1;
        //双指针，index2遇到重复字母时，后移index1使其跳到第一个与index2指向元素不一样时，或一样时为index2
        while (index2 < s.length()){
            int i = index2-1;
            while (i>=index1 && s.charAt(i) != s.charAt(index2)){
                i--;
            }
            if(i < index1 && (index2-index1+1) > maxLength){
                System.out.println("index2,index1:"+index2+","+index1);
                maxLength = index2-index1+1;
            }else{
                index1 = i+1;
            }
            index2 = index2 + 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        String str = "abcabcbb";
//        String str = "bbbbbb";
        String str = "pwwkew";
//        String str = "absnobahsoabsahsoabsajsabaob";
//        String str = "jdgfsiesgf";
        int i = lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}
