package 剑指offer.medium;

import java.util.Scanner;

/**
 * TODO
 * leetcode 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * @author 苞谷洁子
 * @ClassName MaxProfit
 * @date 2021/10/25 21:03
 */
public class MaxProfit {
    public static int maxProfit(int[] prices) {

        int max = 0;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++){
            if(minNum > prices[i]){
                minNum = prices[i];
                maxNum = prices[i];
            }
            if(maxNum < prices[i]){
                maxNum = prices[i];
                if(max < maxNum - minNum){
                    max = maxNum - minNum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for(int i=0;i<s1.length;i++){
            nums[i] = Integer.valueOf(s1[i]);
        }
        System.out.println(maxProfit(nums));
    }
}
