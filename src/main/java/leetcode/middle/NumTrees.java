package leetcode.middle;

import java.util.Map;
import java.util.Scanner;

/**
 * TODO
 * leetcode 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * @author 苞谷洁子
 * @ClassName NumTrees
 * @date 2021/11/7 21:41
 */
public class NumTrees {
//类似leetcode95解法，执行用时仅击败5%
//    public int numTrees(int n) {
//        int i = treeNum(1, n);
//        return i;
//    }
//    public int treeNum(int start,int end){
//        if(start >= end){
//            return 1;
//        }
//        int sum = 0;
//        for(int i=start;i<=end;i++){
//            int left = treeNum(start, i - 1);
//            int right = treeNum(i+1, end);
//            sum += left * right;
//        }
//        return sum;
//    }
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i<=n;i++){
            int sum = 0;
            for(int j = 0;j<i;j++){
                sum += nums[j] * nums[i-j-1];
            }
            nums[i] = sum;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(new NumTrees().numTrees(i));
    }
}
