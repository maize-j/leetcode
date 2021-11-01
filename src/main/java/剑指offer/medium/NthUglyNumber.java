package 剑指offer.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * leetcode 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数.
 * @author 苞谷洁子
 * @ClassName NthUglyNumber
 * @date 2021/10/14 20:11
 */
public class NthUglyNumber {

    //官方动态规划解法
//    public int nthUglyNumber(int n) {
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        int p2 = 1, p3 = 1, p5 = 1;
//        for (int i = 2; i <= n; i++) {
//            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
//            dp[i] = Math.min(Math.min(num2, num3), num5);
//            if (dp[i] == num2) {
//                p2++;
//            }
//            if (dp[i] == num3) {
//                p3++;
//            }
//            if (dp[i] == num5) {
//                p5++;
//            }
//        }
//        return dp[n];
//    }

    //用map缓存超出内存限制
    static List<Integer> list;
    public static int nthUglyNumber(int n) {
        int num = 0;
        list = new ArrayList<>();
        while (n > 0){
            num = num +1;
            if(isUgly(num)){
                n = n-1;
            }
        }
        return num;
    }

    public static boolean isUgly(int n){
        if(n <= 3){
            return true;
        }
        int[] nums = {2,3,5};
        for(int i = 0;i<3;i++){
            if(n%nums[i] == 0){
                if(list.contains(n/nums[i])){
                    return true;
                }
                if(isUgly(n/nums[i])){
                    list.add(n/nums[i]);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 15;
        int i = nthUglyNumber(n);
        System.out.println();
        System.out.println(i);
    }
}
