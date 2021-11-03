package leetcode.middle;

import java.util.Scanner;

/**
 * TODO
 * leetcode 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * @author 苞谷洁子
 * @ClassName NumDecodings
 * @date 2021/11/3 20:48
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int[] nums = new int[s.length()];
        nums[0] = 1;
        char c = s.charAt(0);
        int num = (c-'0') * 10 + s.charAt(1) - '0';
        if(s.charAt(1)=='0'&&num>26){
            return 0;
        }else if(s.charAt(1)=='0' || num>26){
            nums[1] = 1;
        }else{
            nums[1] = 2;
        }
        c = s.charAt(1);
        for(int i = 2;i<s.length();i++){
            if(s.charAt(i) == '0'){
                if(c > '2'|| c <= '0'){
                    return 0;
                }else{
                    nums[i-1] = nums[i-2];
                }
                nums[i] = nums[i-1];
            }else{
                int temp = (c-'0') * 10 + s.charAt(i) - '0';
                if(c == '0' || temp > 26){
                    nums[i] = nums[i-1];
                }else{
                    nums[i] = nums[i-1]+nums[i-2];
                }
            }
            c = s.charAt(i);
        }
        return nums[s.length()-1];
//========官方解答==========
//        int n = s.length();
//        // a = f[i-2], b = f[i-1], c=f[i]
//        int a = 0, b = 1, c = 0;
//        for (int i = 1; i <= n; ++i) {
//            c = 0;
//            if (s.charAt(i - 1) != '0') {
//                c += b;
//            }
//            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
//                c += a;
//            }
//            a = b;
//            b = c;
//        }
//        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(numDecodings(s));
    }
}
