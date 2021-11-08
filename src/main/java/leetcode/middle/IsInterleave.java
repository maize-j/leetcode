package leetcode.middle;

import java.util.Scanner;

/**
 * TODO
 * leetcode 97. 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * @author 苞谷洁子
 * @ClassName IsInterleave
 * @date 2021/11/8 20:10
 */
public class IsInterleave {
    //动态规划
    //状态flag[i][j]取决于 f[i-1][j]和s2[i]==s3[i+j-1] 或 f[i][j-1]和s2[j]==s3[i+j-1]
    //|n - m| <= 1这个条件有用吗？交错一定会满足这个条件
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1 == null || "".equals(s1)) || (s2 == null || "".equals(s2))){
            if(s3 == null || "".equals(s3)){
                return true;
            }else if(s3.equals(s1) || s3.equals(s2)){
                return true;
            }else{
                return false;
            }
        }
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();
        if(s1Length + s2Length != s3Length){
            return false;
        }
        boolean[][] flag = new boolean[s1Length+1][s2Length+1];
        flag[0][0] = true;
        for(int i = 0;i<=s1Length;i++){
            for(int j = 0;j<=s2Length;j++){
                if(i>0){
                    flag[i][j] = flag[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                }
                if(!flag[i][j] && j>0){
                    flag[i][j] = flag[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                }
            }
        }
        return flag[s1Length][s2Length];
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
        String s1 = "aabcc";
//        String s2 = sc.nextLine();
        String s2 = "dbbca";
//        String s3 = sc.nextLine();
        String s3 = "aadbbcbcac";
        System.out.println(new IsInterleave().isInterleave(s1, s2, s3));
    }
}
