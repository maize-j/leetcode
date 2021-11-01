package 剑指offer.medium;

import java.util.Scanner;

/**
 * TODO
 * leetcode 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * @author 苞谷洁子
 * @ClassName DicesProbability
 * @date 2021/10/24 16:39
 */
public class DicesProbability {
    /**
     * 6*n - n种可能
     * 每一种摇出来的可能性为1/6^n
     */
    public static double[][] probabilityArray;
    public static double[] dicesProbability(int n) {
        probabilityArray = new double[n+1][6*n+1];
        double[] res = new double[6*n-n+1];
        int index = 0;
        for(int i = n;i<=6*n;i++){
            res[index++] = probability(n,i);
        }
        return res;
    }

    public static double probability(int n,int sum){
        if(n == 1){
            if(sum <= 6){
                probabilityArray[n][sum] = 1.0/6;
                return probabilityArray[n][sum];
            }else{
                return 0;
            }
        }
        if(probabilityArray[n][sum] > 0){
            return probabilityArray[n][sum];
        }
        double res = 0;
        for(int temp = 1;temp <=6;temp++){
            if(sum-temp <= 0){
                break;
            }
            if(probabilityArray[n-1][sum-temp]-0 < 10e-6){
                probabilityArray[n-1][sum-temp] = probability(n-1,sum-temp);
            }

            res += probabilityArray[n-1][sum-temp]/6.0;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        double[] doubles = dicesProbability(i);
        for(double b:doubles){
            System.out.print(b+"\t");
        }
    }
}
