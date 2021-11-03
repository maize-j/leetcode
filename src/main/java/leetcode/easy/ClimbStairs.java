package leetcode.easy;

import java.util.Scanner;

/**
 * TODO
 * leetccode 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @author 苞谷洁子
 * @ClassName ClimbStairs
 * @date 2021/11/3 20:38
 */
public class ClimbStairs {
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] path = new int[n];
        path[0] = 1;
        path[1] = 2;
        for(int i = 2;i<n;i++){
            path[i] = path[i-1] + path[i-2];
        }
        return path[n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(climbStairs(i));
    }
}
