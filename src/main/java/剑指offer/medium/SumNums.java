package 剑指offer.medium;

import java.util.Scanner;

/**
 * TODO
 * leetcode 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author 苞谷洁子
 * @ClassName SumNums
 * @date 2021/10/25 21:35
 */
public class SumNums {
    public static int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(sumNums(i));
    }
}
